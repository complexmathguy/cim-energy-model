import React, { Component } from 'react'
import MeasurementService from '../services/MeasurementService'

class ListMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                measurements: []
        }
        this.addMeasurement = this.addMeasurement.bind(this);
        this.editMeasurement = this.editMeasurement.bind(this);
        this.deleteMeasurement = this.deleteMeasurement.bind(this);
    }

    deleteMeasurement(id){
        MeasurementService.deleteMeasurement(id).then( res => {
            this.setState({measurements: this.state.measurements.filter(measurement => measurement.measurementId !== id)});
        });
    }
    viewMeasurement(id){
        this.props.history.push(`/view-measurement/${id}`);
    }
    editMeasurement(id){
        this.props.history.push(`/add-measurement/${id}`);
    }

    componentDidMount(){
        MeasurementService.getMeasurements().then((res) => {
            this.setState({ measurements: res.data});
        });
    }

    addMeasurement(){
        this.props.history.push('/add-measurement/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Measurement List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMeasurement}> Add Measurement</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> MeasurementType </th>
                                    <th> Phases </th>
                                    <th> UnitMultiplier </th>
                                    <th> UnitSymbol </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.measurements.map(
                                        measurement => 
                                        <tr key = {measurement.measurementId}>
                                             <td> { measurement.measurementType } </td>
                                             <td> { measurement.phases } </td>
                                             <td> { measurement.unitMultiplier } </td>
                                             <td> { measurement.unitSymbol } </td>
                                             <td>
                                                 <button onClick={ () => this.editMeasurement(measurement.measurementId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMeasurement(measurement.measurementId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMeasurement(measurement.measurementId)} className="btn btn-info btn-sm">View </button>
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

export default ListMeasurementComponent
