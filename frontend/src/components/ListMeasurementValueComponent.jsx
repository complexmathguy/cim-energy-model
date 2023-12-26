import React, { Component } from 'react'
import MeasurementValueService from '../services/MeasurementValueService'

class ListMeasurementValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                measurementValues: []
        }
        this.addMeasurementValue = this.addMeasurementValue.bind(this);
        this.editMeasurementValue = this.editMeasurementValue.bind(this);
        this.deleteMeasurementValue = this.deleteMeasurementValue.bind(this);
    }

    deleteMeasurementValue(id){
        MeasurementValueService.deleteMeasurementValue(id).then( res => {
            this.setState({measurementValues: this.state.measurementValues.filter(measurementValue => measurementValue.measurementValueId !== id)});
        });
    }
    viewMeasurementValue(id){
        this.props.history.push(`/view-measurementValue/${id}`);
    }
    editMeasurementValue(id){
        this.props.history.push(`/add-measurementValue/${id}`);
    }

    componentDidMount(){
        MeasurementValueService.getMeasurementValues().then((res) => {
            this.setState({ measurementValues: res.data});
        });
    }

    addMeasurementValue(){
        this.props.history.push('/add-measurementValue/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MeasurementValue List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMeasurementValue}> Add MeasurementValue</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> SensorAccuracy </th>
                                    <th> TimeStamp </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.measurementValues.map(
                                        measurementValue => 
                                        <tr key = {measurementValue.measurementValueId}>
                                             <td> { measurementValue.sensorAccuracy } </td>
                                             <td> { measurementValue.timeStamp } </td>
                                             <td>
                                                 <button onClick={ () => this.editMeasurementValue(measurementValue.measurementValueId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMeasurementValue(measurementValue.measurementValueId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMeasurementValue(measurementValue.measurementValueId)} className="btn btn-info btn-sm">View </button>
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

export default ListMeasurementValueComponent
