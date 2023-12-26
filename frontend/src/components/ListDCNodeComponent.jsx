import React, { Component } from 'react'
import DCNodeService from '../services/DCNodeService'

class ListDCNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCNodes: []
        }
        this.addDCNode = this.addDCNode.bind(this);
        this.editDCNode = this.editDCNode.bind(this);
        this.deleteDCNode = this.deleteDCNode.bind(this);
    }

    deleteDCNode(id){
        DCNodeService.deleteDCNode(id).then( res => {
            this.setState({dCNodes: this.state.dCNodes.filter(dCNode => dCNode.dCNodeId !== id)});
        });
    }
    viewDCNode(id){
        this.props.history.push(`/view-dCNode/${id}`);
    }
    editDCNode(id){
        this.props.history.push(`/add-dCNode/${id}`);
    }

    componentDidMount(){
        DCNodeService.getDCNodes().then((res) => {
            this.setState({ dCNodes: res.data});
        });
    }

    addDCNode(){
        this.props.history.push('/add-dCNode/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCNode List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCNode}> Add DCNode</button>
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
                                    this.state.dCNodes.map(
                                        dCNode => 
                                        <tr key = {dCNode.dCNodeId}>
                                             <td>
                                                 <button onClick={ () => this.editDCNode(dCNode.dCNodeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCNode(dCNode.dCNodeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCNode(dCNode.dCNodeId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCNodeComponent
