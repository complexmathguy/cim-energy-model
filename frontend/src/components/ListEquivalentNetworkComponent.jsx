import React, { Component } from 'react'
import EquivalentNetworkService from '../services/EquivalentNetworkService'

class ListEquivalentNetworkComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equivalentNetworks: []
        }
        this.addEquivalentNetwork = this.addEquivalentNetwork.bind(this);
        this.editEquivalentNetwork = this.editEquivalentNetwork.bind(this);
        this.deleteEquivalentNetwork = this.deleteEquivalentNetwork.bind(this);
    }

    deleteEquivalentNetwork(id){
        EquivalentNetworkService.deleteEquivalentNetwork(id).then( res => {
            this.setState({equivalentNetworks: this.state.equivalentNetworks.filter(equivalentNetwork => equivalentNetwork.equivalentNetworkId !== id)});
        });
    }
    viewEquivalentNetwork(id){
        this.props.history.push(`/view-equivalentNetwork/${id}`);
    }
    editEquivalentNetwork(id){
        this.props.history.push(`/add-equivalentNetwork/${id}`);
    }

    componentDidMount(){
        EquivalentNetworkService.getEquivalentNetworks().then((res) => {
            this.setState({ equivalentNetworks: res.data});
        });
    }

    addEquivalentNetwork(){
        this.props.history.push('/add-equivalentNetwork/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquivalentNetwork List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquivalentNetwork}> Add EquivalentNetwork</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.equivalentNetworks.map(
                                        equivalentNetwork => 
                                        <tr key = {equivalentNetwork.equivalentNetworkId}>
                                             <td>
                                                 <button onClick={ () => this.editEquivalentNetwork(equivalentNetwork.equivalentNetworkId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquivalentNetwork(equivalentNetwork.equivalentNetworkId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquivalentNetwork(equivalentNetwork.equivalentNetworkId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListEquivalentNetworkComponent
