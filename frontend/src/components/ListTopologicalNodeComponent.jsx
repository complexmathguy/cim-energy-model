import React, { Component } from 'react'
import TopologicalNodeService from '../services/TopologicalNodeService'

class ListTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                topologicalNodes: []
        }
        this.addTopologicalNode = this.addTopologicalNode.bind(this);
        this.editTopologicalNode = this.editTopologicalNode.bind(this);
        this.deleteTopologicalNode = this.deleteTopologicalNode.bind(this);
    }

    deleteTopologicalNode(id){
        TopologicalNodeService.deleteTopologicalNode(id).then( res => {
            this.setState({topologicalNodes: this.state.topologicalNodes.filter(topologicalNode => topologicalNode.topologicalNodeId !== id)});
        });
    }
    viewTopologicalNode(id){
        this.props.history.push(`/view-topologicalNode/${id}`);
    }
    editTopologicalNode(id){
        this.props.history.push(`/add-topologicalNode/${id}`);
    }

    componentDidMount(){
        TopologicalNodeService.getTopologicalNodes().then((res) => {
            this.setState({ topologicalNodes: res.data});
        });
    }

    addTopologicalNode(){
        this.props.history.push('/add-topologicalNode/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TopologicalNode List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTopologicalNode}> Add TopologicalNode</button>
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
                                    this.state.topologicalNodes.map(
                                        topologicalNode => 
                                        <tr key = {topologicalNode.topologicalNodeId}>
                                             <td> { topologicalNode.boundaryPoint } </td>
                                             <td> { topologicalNode.fromEndIsoCode } </td>
                                             <td> { topologicalNode.fromEndName } </td>
                                             <td> { topologicalNode.fromEndNameTso } </td>
                                             <td> { topologicalNode.toEndIsoCode } </td>
                                             <td> { topologicalNode.toEndName } </td>
                                             <td> { topologicalNode.toEndNameTso } </td>
                                             <td>
                                                 <button onClick={ () => this.editTopologicalNode(topologicalNode.topologicalNodeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTopologicalNode(topologicalNode.topologicalNodeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTopologicalNode(topologicalNode.topologicalNodeId)} className="btn btn-info btn-sm">View </button>
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

export default ListTopologicalNodeComponent
