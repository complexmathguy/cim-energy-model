import React, { Component } from 'react'
import ENTSOEConnectivityNodeService from '../services/ENTSOEConnectivityNodeService'

class ListENTSOEConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                eNTSOEConnectivityNodes: []
        }
        this.addENTSOEConnectivityNode = this.addENTSOEConnectivityNode.bind(this);
        this.editENTSOEConnectivityNode = this.editENTSOEConnectivityNode.bind(this);
        this.deleteENTSOEConnectivityNode = this.deleteENTSOEConnectivityNode.bind(this);
    }

    deleteENTSOEConnectivityNode(id){
        ENTSOEConnectivityNodeService.deleteENTSOEConnectivityNode(id).then( res => {
            this.setState({eNTSOEConnectivityNodes: this.state.eNTSOEConnectivityNodes.filter(eNTSOEConnectivityNode => eNTSOEConnectivityNode.eNTSOEConnectivityNodeId !== id)});
        });
    }
    viewENTSOEConnectivityNode(id){
        this.props.history.push(`/view-eNTSOEConnectivityNode/${id}`);
    }
    editENTSOEConnectivityNode(id){
        this.props.history.push(`/add-eNTSOEConnectivityNode/${id}`);
    }

    componentDidMount(){
        ENTSOEConnectivityNodeService.getENTSOEConnectivityNodes().then((res) => {
            this.setState({ eNTSOEConnectivityNodes: res.data});
        });
    }

    addENTSOEConnectivityNode(){
        this.props.history.push('/add-eNTSOEConnectivityNode/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ENTSOEConnectivityNode List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addENTSOEConnectivityNode}> Add ENTSOEConnectivityNode</button>
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
                                    this.state.eNTSOEConnectivityNodes.map(
                                        eNTSOEConnectivityNode => 
                                        <tr key = {eNTSOEConnectivityNode.eNTSOEConnectivityNodeId}>
                                             <td>
                                                 <button onClick={ () => this.editENTSOEConnectivityNode(eNTSOEConnectivityNode.eNTSOEConnectivityNodeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteENTSOEConnectivityNode(eNTSOEConnectivityNode.eNTSOEConnectivityNodeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewENTSOEConnectivityNode(eNTSOEConnectivityNode.eNTSOEConnectivityNodeId)} className="btn btn-info btn-sm">View </button>
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

export default ListENTSOEConnectivityNodeComponent
