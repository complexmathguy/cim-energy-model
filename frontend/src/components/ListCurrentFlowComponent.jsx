import React, { Component } from 'react'
import CurrentFlowService from '../services/CurrentFlowService'

class ListCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                currentFlows: []
        }
        this.addCurrentFlow = this.addCurrentFlow.bind(this);
        this.editCurrentFlow = this.editCurrentFlow.bind(this);
        this.deleteCurrentFlow = this.deleteCurrentFlow.bind(this);
    }

    deleteCurrentFlow(id){
        CurrentFlowService.deleteCurrentFlow(id).then( res => {
            this.setState({currentFlows: this.state.currentFlows.filter(currentFlow => currentFlow.currentFlowId !== id)});
        });
    }
    viewCurrentFlow(id){
        this.props.history.push(`/view-currentFlow/${id}`);
    }
    editCurrentFlow(id){
        this.props.history.push(`/add-currentFlow/${id}`);
    }

    componentDidMount(){
        CurrentFlowService.getCurrentFlows().then((res) => {
            this.setState({ currentFlows: res.data});
        });
    }

    addCurrentFlow(){
        this.props.history.push('/add-currentFlow/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">CurrentFlow List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCurrentFlow}> Add CurrentFlow</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.currentFlows.map(
                                        currentFlow => 
                                        <tr key = {currentFlow.currentFlowId}>
                                             <td> { currentFlow.multiplier } </td>
                                             <td> { currentFlow.unit } </td>
                                             <td> { currentFlow.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editCurrentFlow(currentFlow.currentFlowId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCurrentFlow(currentFlow.currentFlowId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCurrentFlow(currentFlow.currentFlowId)} className="btn btn-info btn-sm">View </button>
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

export default ListCurrentFlowComponent
