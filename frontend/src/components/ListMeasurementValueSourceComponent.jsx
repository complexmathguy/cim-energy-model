import React, { Component } from 'react'
import MeasurementValueSourceService from '../services/MeasurementValueSourceService'

class ListMeasurementValueSourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                measurementValueSources: []
        }
        this.addMeasurementValueSource = this.addMeasurementValueSource.bind(this);
        this.editMeasurementValueSource = this.editMeasurementValueSource.bind(this);
        this.deleteMeasurementValueSource = this.deleteMeasurementValueSource.bind(this);
    }

    deleteMeasurementValueSource(id){
        MeasurementValueSourceService.deleteMeasurementValueSource(id).then( res => {
            this.setState({measurementValueSources: this.state.measurementValueSources.filter(measurementValueSource => measurementValueSource.measurementValueSourceId !== id)});
        });
    }
    viewMeasurementValueSource(id){
        this.props.history.push(`/view-measurementValueSource/${id}`);
    }
    editMeasurementValueSource(id){
        this.props.history.push(`/add-measurementValueSource/${id}`);
    }

    componentDidMount(){
        MeasurementValueSourceService.getMeasurementValueSources().then((res) => {
            this.setState({ measurementValueSources: res.data});
        });
    }

    addMeasurementValueSource(){
        this.props.history.push('/add-measurementValueSource/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MeasurementValueSource List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMeasurementValueSource}> Add MeasurementValueSource</button>
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
                                    this.state.measurementValueSources.map(
                                        measurementValueSource => 
                                        <tr key = {measurementValueSource.measurementValueSourceId}>
                                             <td>
                                                 <button onClick={ () => this.editMeasurementValueSource(measurementValueSource.measurementValueSourceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMeasurementValueSource(measurementValueSource.measurementValueSourceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMeasurementValueSource(measurementValueSource.measurementValueSourceId)} className="btn btn-info btn-sm">View </button>
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

export default ListMeasurementValueSourceComponent
