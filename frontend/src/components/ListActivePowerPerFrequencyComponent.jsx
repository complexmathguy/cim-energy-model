import React, { Component } from 'react'
import ActivePowerPerFrequencyService from '../services/ActivePowerPerFrequencyService'

class ListActivePowerPerFrequencyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                activePowerPerFrequencys: []
        }
        this.addActivePowerPerFrequency = this.addActivePowerPerFrequency.bind(this);
        this.editActivePowerPerFrequency = this.editActivePowerPerFrequency.bind(this);
        this.deleteActivePowerPerFrequency = this.deleteActivePowerPerFrequency.bind(this);
    }

    deleteActivePowerPerFrequency(id){
        ActivePowerPerFrequencyService.deleteActivePowerPerFrequency(id).then( res => {
            this.setState({activePowerPerFrequencys: this.state.activePowerPerFrequencys.filter(activePowerPerFrequency => activePowerPerFrequency.activePowerPerFrequencyId !== id)});
        });
    }
    viewActivePowerPerFrequency(id){
        this.props.history.push(`/view-activePowerPerFrequency/${id}`);
    }
    editActivePowerPerFrequency(id){
        this.props.history.push(`/add-activePowerPerFrequency/${id}`);
    }

    componentDidMount(){
        ActivePowerPerFrequencyService.getActivePowerPerFrequencys().then((res) => {
            this.setState({ activePowerPerFrequencys: res.data});
        });
    }

    addActivePowerPerFrequency(){
        this.props.history.push('/add-activePowerPerFrequency/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ActivePowerPerFrequency List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addActivePowerPerFrequency}> Add ActivePowerPerFrequency</button>
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
                                    this.state.activePowerPerFrequencys.map(
                                        activePowerPerFrequency => 
                                        <tr key = {activePowerPerFrequency.activePowerPerFrequencyId}>
                                             <td> { activePowerPerFrequency.denominatorMultiplier } </td>
                                             <td> { activePowerPerFrequency.denominatorUnit } </td>
                                             <td> { activePowerPerFrequency.multiplier } </td>
                                             <td> { activePowerPerFrequency.unit } </td>
                                             <td> { activePowerPerFrequency.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editActivePowerPerFrequency(activePowerPerFrequency.activePowerPerFrequencyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteActivePowerPerFrequency(activePowerPerFrequency.activePowerPerFrequencyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewActivePowerPerFrequency(activePowerPerFrequency.activePowerPerFrequencyId)} className="btn btn-info btn-sm">View </button>
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

export default ListActivePowerPerFrequencyComponent
