import React, { Component } from 'react'
import ENTSOETopologicalNodeService from '../services/ENTSOETopologicalNodeService'

class ListENTSOETopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                eNTSOETopologicalNodes: []
        }
        this.addENTSOETopologicalNode = this.addENTSOETopologicalNode.bind(this);
        this.editENTSOETopologicalNode = this.editENTSOETopologicalNode.bind(this);
        this.deleteENTSOETopologicalNode = this.deleteENTSOETopologicalNode.bind(this);
    }

    deleteENTSOETopologicalNode(id){
        ENTSOETopologicalNodeService.deleteENTSOETopologicalNode(id).then( res => {
            this.setState({eNTSOETopologicalNodes: this.state.eNTSOETopologicalNodes.filter(eNTSOETopologicalNode => eNTSOETopologicalNode.eNTSOETopologicalNodeId !== id)});
        });
    }
    viewENTSOETopologicalNode(id){
        this.props.history.push(`/view-eNTSOETopologicalNode/${id}`);
    }
    editENTSOETopologicalNode(id){
        this.props.history.push(`/add-eNTSOETopologicalNode/${id}`);
    }

    componentDidMount(){
        ENTSOETopologicalNodeService.getENTSOETopologicalNodes().then((res) => {
            this.setState({ eNTSOETopologicalNodes: res.data});
        });
    }

    addENTSOETopologicalNode(){
        this.props.history.push('/add-eNTSOETopologicalNode/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ENTSOETopologicalNode List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addENTSOETopologicalNode}> Add ENTSOETopologicalNode</button>
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
                                    this.state.eNTSOETopologicalNodes.map(
                                        eNTSOETopologicalNode => 
                                        <tr key = {eNTSOETopologicalNode.eNTSOETopologicalNodeId}>
                                             <td>
                                                 <button onClick={ () => this.editENTSOETopologicalNode(eNTSOETopologicalNode.eNTSOETopologicalNodeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteENTSOETopologicalNode(eNTSOETopologicalNode.eNTSOETopologicalNodeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewENTSOETopologicalNode(eNTSOETopologicalNode.eNTSOETopologicalNodeId)} className="btn btn-info btn-sm">View </button>
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

export default ListENTSOETopologicalNodeComponent
