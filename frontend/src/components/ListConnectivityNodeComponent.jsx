import React, { Component } from 'react'
import ConnectivityNodeService from '../services/ConnectivityNodeService'

class ListConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                connectivityNodes: []
        }
        this.addConnectivityNode = this.addConnectivityNode.bind(this);
        this.editConnectivityNode = this.editConnectivityNode.bind(this);
        this.deleteConnectivityNode = this.deleteConnectivityNode.bind(this);
    }

    deleteConnectivityNode(id){
        ConnectivityNodeService.deleteConnectivityNode(id).then( res => {
            this.setState({connectivityNodes: this.state.connectivityNodes.filter(connectivityNode => connectivityNode.connectivityNodeId !== id)});
        });
    }
    viewConnectivityNode(id){
        this.props.history.push(`/view-connectivityNode/${id}`);
    }
    editConnectivityNode(id){
        this.props.history.push(`/add-connectivityNode/${id}`);
    }

    componentDidMount(){
        ConnectivityNodeService.getConnectivityNodes().then((res) => {
            this.setState({ connectivityNodes: res.data});
        });
    }

    addConnectivityNode(){
        this.props.history.push('/add-connectivityNode/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ConnectivityNode List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConnectivityNode}> Add ConnectivityNode</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BoundaryPoint </th>
                                    <th> FromEndIsoCode </th>
                                    <th> FromEndName </th>
                                    <th> FromEndNameTso </th>
                                    <th> ToEndIsoCode </th>
                                    <th> ToEndName </th>
                                    <th> ToEndNameTso </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.connectivityNodes.map(
                                        connectivityNode => 
                                        <tr key = {connectivityNode.connectivityNodeId}>
                                             <td> { connectivityNode.boundaryPoint } </td>
                                             <td> { connectivityNode.fromEndIsoCode } </td>
                                             <td> { connectivityNode.fromEndName } </td>
                                             <td> { connectivityNode.fromEndNameTso } </td>
                                             <td> { connectivityNode.toEndIsoCode } </td>
                                             <td> { connectivityNode.toEndName } </td>
                                             <td> { connectivityNode.toEndNameTso } </td>
                                             <td>
                                                 <button onClick={ () => this.editConnectivityNode(connectivityNode.connectivityNodeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConnectivityNode(connectivityNode.connectivityNodeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConnectivityNode(connectivityNode.connectivityNodeId)} className="btn btn-info btn-sm">View </button>
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

export default ListConnectivityNodeComponent
