import React, { Component } from 'react'
import ActivePowerPerCurrentFlowService from '../services/ActivePowerPerCurrentFlowService'

class ListActivePowerPerCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                activePowerPerCurrentFlows: []
        }
        this.addActivePowerPerCurrentFlow = this.addActivePowerPerCurrentFlow.bind(this);
        this.editActivePowerPerCurrentFlow = this.editActivePowerPerCurrentFlow.bind(this);
        this.deleteActivePowerPerCurrentFlow = this.deleteActivePowerPerCurrentFlow.bind(this);
    }

    deleteActivePowerPerCurrentFlow(id){
        ActivePowerPerCurrentFlowService.deleteActivePowerPerCurrentFlow(id).then( res => {
            this.setState({activePowerPerCurrentFlows: this.state.activePowerPerCurrentFlows.filter(activePowerPerCurrentFlow => activePowerPerCurrentFlow.activePowerPerCurrentFlowId !== id)});
        });
    }
    viewActivePowerPerCurrentFlow(id){
        this.props.history.push(`/view-activePowerPerCurrentFlow/${id}`);
    }
    editActivePowerPerCurrentFlow(id){
        this.props.history.push(`/add-activePowerPerCurrentFlow/${id}`);
    }

    componentDidMount(){
        ActivePowerPerCurrentFlowService.getActivePowerPerCurrentFlows().then((res) => {
            this.setState({ activePowerPerCurrentFlows: res.data});
        });
    }

    addActivePowerPerCurrentFlow(){
        this.props.history.push('/add-activePowerPerCurrentFlow/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ActivePowerPerCurrentFlow List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addActivePowerPerCurrentFlow}> Add ActivePowerPerCurrentFlow</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> DenominatorMultiplier </th>
                                    <th> DenominatorUnit </th>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.activePowerPerCurrentFlows.map(
                                        activePowerPerCurrentFlow => 
                                        <tr key = {activePowerPerCurrentFlow.activePowerPerCurrentFlowId}>
                                             <td> { activePowerPerCurrentFlow.denominatorMultiplier } </td>
                                             <td> { activePowerPerCurrentFlow.denominatorUnit } </td>
                                             <td> { activePowerPerCurrentFlow.multiplier } </td>
                                             <td> { activePowerPerCurrentFlow.unit } </td>
                                             <td> { activePowerPerCurrentFlow.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editActivePowerPerCurrentFlow(activePowerPerCurrentFlow.activePowerPerCurrentFlowId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteActivePowerPerCurrentFlow(activePowerPerCurrentFlow.activePowerPerCurrentFlowId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewActivePowerPerCurrentFlow(activePowerPerCurrentFlow.activePowerPerCurrentFlowId)} className="btn btn-info btn-sm">View </button>
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

export default ListActivePowerPerCurrentFlowComponent
