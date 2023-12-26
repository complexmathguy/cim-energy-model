import React, { Component } from 'react'
import MeasurementValueQualityService from '../services/MeasurementValueQualityService';

class UpdateMeasurementValueQualityComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMeasurementValueQuality = this.updateMeasurementValueQuality.bind(this);

    }

    componentDidMount(){
        MeasurementValueQualityService.getMeasurementValueQualityById(this.state.id).then( (res) =>{
            let measurementValueQuality = res.data;
            this.setState({
            });
        });
    }

    updateMeasurementValueQuality = (e) => {
        e.preventDefault();
        let measurementValueQuality = {
            measurementValueQualityId: this.state.id,
        };
        console.log('measurementValueQuality => ' + JSON.stringify(measurementValueQuality));
        console.log('id => ' + JSON.stringify(this.state.id));
        MeasurementValueQualityService.updateMeasurementValueQuality(measurementValueQuality).then( res => {
            this.props.history.push('/measurementValueQualitys');
        });
    }


    cancel(){
        this.props.history.push('/measurementValueQualitys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MeasurementValueQuality</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMeasurementValueQuality}>Save</button>
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

export default UpdateMeasurementValueQualityComponent
