import React, { Component } from 'react'
import ActivePowerLimitService from '../services/ActivePowerLimitService'

class ListActivePowerLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                activePowerLimits: []
        }
        this.addActivePowerLimit = this.addActivePowerLimit.bind(this);
        this.editActivePowerLimit = this.editActivePowerLimit.bind(this);
        this.deleteActivePowerLimit = this.deleteActivePowerLimit.bind(this);
    }

    deleteActivePowerLimit(id){
        ActivePowerLimitService.deleteActivePowerLimit(id).then( res => {
            this.setState({activePowerLimits: this.state.activePowerLimits.filter(activePowerLimit => activePowerLimit.activePowerLimitId !== id)});
        });
    }
    viewActivePowerLimit(id){
        this.props.history.push(`/view-activePowerLimit/${id}`);
    }
    editActivePowerLimit(id){
        this.props.history.push(`/add-activePowerLimit/${id}`);
    }

    componentDidMount(){
        ActivePowerLimitService.getActivePowerLimits().then((res) => {
            this.setState({ activePowerLimits: res.data});
        });
    }

    addActivePowerLimit(){
        this.props.history.push('/add-activePowerLimit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ActivePowerLimit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addActivePowerLimit}> Add ActivePowerLimit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.activePowerLimits.map(
                                        activePowerLimit => 
                                        <tr key = {activePowerLimit.activePowerLimitId}>
                                             <td> { activePowerLimit.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editActivePowerLimit(activePowerLimit.activePowerLimitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteActivePowerLimit(activePowerLimit.activePowerLimitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewActivePowerLimit(activePowerLimit.activePowerLimitId)} className="btn btn-info btn-sm">View </button>
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

export default ListActivePowerLimitComponent
