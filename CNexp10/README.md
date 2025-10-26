# Mininet Network Emulation with POX Controller

This guide provides a comprehensive walkthrough for setting up and running Mininet network emulation with a POX SDN controller.

## Prerequisites

- Ubuntu Linux environment
- Mininet installed
- Python 3.x
- Basic knowledge of SDN concepts

---

## Step 1: Launch Mininet

Open a terminal in Ubuntu and run the following command:

```bash
sudo mn --topo single,3 --mac --switch ovsk --controller remote
```

**What this does:** Creates a simple topology with 1 switch and 3 hosts, configured to connect to a remote controller.

---

## Step 2: Test Connectivity

Verify that all hosts can communicate with each other:

```bash
pingall
```

**What this does:** Sends ICMP packets between all hosts to verify end-to-end connectivity.

---

## Step 3: Start Mininet CLI

Run interactive commands inside the Mininet CLI to test specific host connectivity:

```bash
h1 ping h2
h1 ping h3
```

---

## Step 4: Create Custom Topology Using Python

Create a Python script named `topo.py` with the following content:

```python
from mininet.topo import Topo
from mininet.net import Mininet
from mininet.node import RemoteController
from mininet.cli import CLI

class MyTopo(Topo):
    def build(self):
        # Add hosts
        h1 = self.addHost('h1')
        h2 = self.addHost('h2')
        
        # Add switch
        s1 = self.addSwitch('s1')
        
        # Add links
        self.addLink(h1, s1)
        self.addLink(h2, s1)

# Create and run the topology
topo = MyTopo()
net = Mininet(topo=topo, controller=RemoteController)
net.start()
CLI(net)
net.stop()
```

Run the script using:

```bash
sudo python3 topo.py
```

---

## Step 5: Install and Run POX Controller

Clone the POX repository and start the L2 learning controller:

```bash
git clone https://github.com/noxrepo/pox.git
cd pox
./pox.py forwarding.l2_learning
```

**What this does:** Installs POX and starts a basic Layer 2 learning switch controller.

---

## Step 6: Connect Mininet to POX Controller

Run Mininet with the remote controller option pointing to your POX instance:

```bash
sudo mn --controller=remote,ip=127.0.0.1,port=6633
```

**What this does:** Connects the Mininet topology to the POX controller running on localhost at port 6633.

---

## Summary

You now have a fully functional Mininet network emulation environment controlled by a POX SDN controller. You can extend this setup by:

- Creating more complex topologies
- Writing custom POX controller modules
- Implementing custom forwarding logic
- Experimenting with different SDN applications

---

## Troubleshooting

- If Mininet fails to start, ensure you're running with `sudo` privileges
- Verify POX is running before launching Mininet with remote controller option
- Check that port 6633 is not blocked by firewall rules

---

## License

This documentation is provided as-is for educational purposes.
