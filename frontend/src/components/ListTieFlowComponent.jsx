import React, { Component } from 'react'
import TieFlowService from '../services/TieFlowService'

class ListTieFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                tieFlows: []
        }
        this.addTieFlow = this.addTieFlow.bind(this);
        this.editTieFlow = this.editTieFlow.bind(this);
        this.deleteTieFlow = this.deleteTieFlow.bind(this);
    }

    deleteTieFlow(id){
        TieFlowService.deleteTieFlow(id).then( res => {
            this.setState({tieFlows: this.state.tieFlows.filter(tieFlow => tieFlow.tieFlowId !== id)});
        });
    }
    viewTieFlow(id){
        this.props.history.push(`/view-tieFlow/${id}`);
    }
    editTieFlow(id){
        this.props.history.push(`/add-tieFlow/${id}`);
    }

    componentDidMount(){
        TieFlowService.getTieFlows().then((res) => {
            this.setState({ tieFlows: res.data});
        });
    }

    addTieFlow(){
        this.props.history.push('/add-tieFlow/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TieFlow List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTieFlow}> Add TieFlow</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> PositiveFlowIn </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.tieFlows.map(
                                        tieFlow => 
                                        <tr key = {tieFlow.tieFlowId}>
                                             <td> { tieFlow.positiveFlowIn } </td>
                                             <td>
                                                 <button onClick={ () => this.editTieFlow(tieFlow.tieFlowId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTieFlow(tieFlow.tieFlowId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTieFlow(tieFlow.tieFlowId)} className="btn btn-info btn-sm">View </button>
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

export default ListTieFlowComponent
