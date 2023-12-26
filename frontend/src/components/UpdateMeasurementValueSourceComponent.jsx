import React, { Component } from 'react'
import MeasurementValueSourceService from '../services/MeasurementValueSourceService';

class UpdateMeasurementValueSourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMeasurementValueSource = this.updateMeasurementValueSource.bind(this);

    }

    componentDidMount(){
        MeasurementValueSourceService.getMeasurementValueSourceById(this.state.id).then( (res) =>{
            let measurementValueSource = res.data;
            this.setState({
            });
        });
    }

    updateMeasurementValueSource = (e) => {
        e.preventDefault();
        let measurementValueSource = {
            measurementValueSourceId: this.state.id,
        };
        console.log('measurementValueSource => ' + JSON.stringify(measurementValueSource));
        console.log('id => ' + JSON.stringify(this.state.id));
        MeasurementValueSourceService.updateMeasurementValueSource(measurementValueSource).then( res => {
            this.props.history.push('/measurementValueSources');
        });
    }


    cancel(){
        this.props.history.push('/measurementValueSources');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MeasurementValueSource</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMeasurementValueSource}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateMeasurementValueSourceComponent
