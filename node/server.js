// Required modules
const fs = require('fs');
const path = require('path');
const express = require('express');

// Initialize Express app
const app = express();
const PORT = 3000;

// Middleware to parse JSON bodies
app.use(express.json());

// Step 3: Perform File System operations
console.log('\n=== File System Operations ===');

// Write to file
fs.writeFileSync('sample.txt', 'Hello, Node.js FS Module!');
console.log('File created: sample.txt');

// Read from file
const data = fs.readFileSync('sample.txt', 'utf8');
console.log("File Content:", data);

// Step 4: Use Path Module
console.log('\n=== Path Module Operations ===');
const filePath = path.join(__dirname, 'sample.txt');
console.log("Absolute File Path:", filePath);
console.log("Directory Name:", __dirname);
console.log("File Name:", path.basename(filePath));
console.log("File Extension:", path.extname(filePath));

// Step 5: Create Express REST API with Middleware
console.log('\n=== Express Server Setup ===');

// Custom logging middleware
app.use((req, res, next) => {
    const timestamp = new Date().toISOString();
    console.log(`[${timestamp}] ${req.method} ${req.url}`);
    next();
});

// Route 1: Welcome endpoint
app.get('/', (req, res) => {
    res.send('Welcome to Node.js REST API');
});

// Route 2: JSON data endpoint
app.get('/data', (req, res) => {
    res.json({ message: "Hello World" });
});

// Route 3: Read file content endpoint
app.get('/file', (req, res) => {
    try {
        const fileContent = fs.readFileSync('sample.txt', 'utf8');
        res.json({ 
            success: true,
            content: fileContent,
            path: filePath
        });
    } catch (error) {
        res.status(500).json({ 
            success: false,
            error: error.message 
        });
    }
});

// Route 4: Write to file endpoint
app.post('/file', (req, res) => {
    try {
        const { content } = req.body;
        if (!content) {
            return res.status(400).json({ 
                success: false,
                error: 'Content is required' 
            });
        }
        
        fs.writeFileSync('sample.txt', content);
        res.json({ 
            success: true,
            message: 'File updated successfully',
            content: content
        });
    } catch (error) {
        res.status(500).json({ 
            success: false,
            error: error.message 
        });
    }
});

// Route 5: Get file info endpoint
app.get('/fileinfo', (req, res) => {
    try {
        const stats = fs.statSync('sample.txt');
        res.json({
            success: true,
            fileInfo: {
                size: stats.size + ' bytes',
                created: stats.birthtime,
                modified: stats.mtime,
                isFile: stats.isFile(),
                isDirectory: stats.isDirectory()
            }
        });
    } catch (error) {
        res.status(500).json({ 
            success: false,
            error: error.message 
        });
    }
});

// Step 6: Start the server
app.listen(PORT, () => {
    console.log(`\nServer running at http://localhost:${PORT}`);
    console.log('\n=== Available Endpoints ===');
    console.log(`GET  http://localhost:${PORT}/         - Welcome message`);
    console.log(`GET  http://localhost:${PORT}/data     - JSON response`);
    console.log(`GET  http://localhost:${PORT}/file     - Read file content`);
    console.log(`POST http://localhost:${PORT}/file     - Update file content`);
    console.log(`GET  http://localhost:${PORT}/fileinfo - Get file information`);
    console.log('\nPress Ctrl+C to stop the server\n');
});
