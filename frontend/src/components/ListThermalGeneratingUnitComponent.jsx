import React, { Component } from 'react'
import ThermalGeneratingUnitService from '../services/ThermalGeneratingUnitService'

class ListThermalGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                thermalGeneratingUnits: []
        }
        this.addThermalGeneratingUnit = this.addThermalGeneratingUnit.bind(this);
        this.editThermalGeneratingUnit = this.editThermalGeneratingUnit.bind(this);
        this.deleteThermalGeneratingUnit = this.deleteThermalGeneratingUnit.bind(this);
    }

    deleteThermalGeneratingUnit(id){
        ThermalGeneratingUnitService.deleteThermalGeneratingUnit(id).then( res => {
            this.setState({thermalGeneratingUnits: this.state.thermalGeneratingUnits.filter(thermalGeneratingUnit => thermalGeneratingUnit.thermalGeneratingUnitId !== id)});
        });
    }
    viewThermalGeneratingUnit(id){
        this.props.history.push(`/view-thermalGeneratingUnit/${id}`);
    }
    editThermalGeneratingUnit(id){
        this.props.history.push(`/add-thermalGeneratingUnit/${id}`);
    }

    componentDidMount(){
        ThermalGeneratingUnitService.getThermalGeneratingUnits().then((res) => {
            this.setState({ thermalGeneratingUnits: res.data});
        });
    }

    addThermalGeneratingUnit(){
        this.props.history.push('/add-thermalGeneratingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ThermalGeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addThermalGeneratingUnit}> Add ThermalGeneratingUnit</button>
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
                                    this.state.thermalGeneratingUnits.map(
                                        thermalGeneratingUnit => 
                                        <tr key = {thermalGeneratingUnit.thermalGeneratingUnitId}>
                                             <td>
                                                 <button onClick={ () => this.editThermalGeneratingUnit(thermalGeneratingUnit.thermalGeneratingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteThermalGeneratingUnit(thermalGeneratingUnit.thermalGeneratingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewThermalGeneratingUnit(thermalGeneratingUnit.thermalGeneratingUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListThermalGeneratingUnitComponent
