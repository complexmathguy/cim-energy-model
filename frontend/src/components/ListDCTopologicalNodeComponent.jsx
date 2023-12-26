import React, { Component } from 'react'
import DCTopologicalNodeService from '../services/DCTopologicalNodeService'

class ListDCTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCTopologicalNodes: []
        }
        this.addDCTopologicalNode = this.addDCTopologicalNode.bind(this);
        this.editDCTopologicalNode = this.editDCTopologicalNode.bind(this);
        this.deleteDCTopologicalNode = this.deleteDCTopologicalNode.bind(this);
    }

    deleteDCTopologicalNode(id){
        DCTopologicalNodeService.deleteDCTopologicalNode(id).then( res => {
            this.setState({dCTopologicalNodes: this.state.dCTopologicalNodes.filter(dCTopologicalNode => dCTopologicalNode.dCTopologicalNodeId !== id)});
        });
    }
    viewDCTopologicalNode(id){
        this.props.history.push(`/view-dCTopologicalNode/${id}`);
    }
    editDCTopologicalNode(id){
        this.props.history.push(`/add-dCTopologicalNode/${id}`);
    }

    componentDidMount(){
        DCTopologicalNodeService.getDCTopologicalNodes().then((res) => {
            this.setState({ dCTopologicalNodes: res.data});
        });
    }

    addDCTopologicalNode(){
        this.props.history.push('/add-dCTopologicalNode/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCTopologicalNode List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCTopologicalNode}> Add DCTopologicalNode</button>
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
                                    this.state.dCTopologicalNodes.map(
                                        dCTopologicalNode => 
                                        <tr key = {dCTopologicalNode.dCTopologicalNodeId}>
                                             <td>
                                                 <button onClick={ () => this.editDCTopologicalNode(dCTopologicalNode.dCTopologicalNodeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCTopologicalNode(dCTopologicalNode.dCTopologicalNodeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCTopologicalNode(dCTopologicalNode.dCTopologicalNodeId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCTopologicalNodeComponent
