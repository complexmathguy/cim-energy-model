import React, { Component } from 'react'
import MeasurementValueQualityService from '../services/MeasurementValueQualityService'

class ListMeasurementValueQualityComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                measurementValueQualitys: []
        }
        this.addMeasurementValueQuality = this.addMeasurementValueQuality.bind(this);
        this.editMeasurementValueQuality = this.editMeasurementValueQuality.bind(this);
        this.deleteMeasurementValueQuality = this.deleteMeasurementValueQuality.bind(this);
    }

    deleteMeasurementValueQuality(id){
        MeasurementValueQualityService.deleteMeasurementValueQuality(id).then( res => {
            this.setState({measurementValueQualitys: this.state.measurementValueQualitys.filter(measurementValueQuality => measurementValueQuality.measurementValueQualityId !== id)});
        });
    }
    viewMeasurementValueQuality(id){
        this.props.history.push(`/view-measurementValueQuality/${id}`);
    }
    editMeasurementValueQuality(id){
        this.props.history.push(`/add-measurementValueQuality/${id}`);
    }

    componentDidMount(){
        MeasurementValueQualityService.getMeasurementValueQualitys().then((res) => {
            this.setState({ measurementValueQualitys: res.data});
        });
    }

    addMeasurementValueQuality(){
        this.props.history.push('/add-measurementValueQuality/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MeasurementValueQuality List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMeasurementValueQuality}> Add MeasurementValueQuality</button>
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
                                    this.state.measurementValueQualitys.map(
                                        measurementValueQuality => 
                                        <tr key = {measurementValueQuality.measurementValueQualityId}>
                                             <td>
                                                 <button onClick={ () => this.editMeasurementValueQuality(measurementValueQuality.measurementValueQualityId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMeasurementValueQuality(measurementValueQuality.measurementValueQualityId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMeasurementValueQuality(measurementValueQuality.measurementValueQualityId)} className="btn btn-info btn-sm">View </button>
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

export default ListMeasurementValueQualityComponent
