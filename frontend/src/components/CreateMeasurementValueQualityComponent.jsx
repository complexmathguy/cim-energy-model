import React, { Component } from 'react'
import MeasurementValueQualityService from '../services/MeasurementValueQualityService';

class CreateMeasurementValueQualityComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MeasurementValueQualityService.getMeasurementValueQualityById(this.state.id).then( (res) =>{
                let measurementValueQuality = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMeasurementValueQuality = (e) => {
        e.preventDefault();
        let measurementValueQuality = {
                measurementValueQualityId: this.state.id,
            };
        console.log('measurementValueQuality => ' + JSON.stringify(measurementValueQuality));

        // step 5
        if(this.state.id === '_add'){
            measurementValueQuality.measurementValueQualityId=''
            MeasurementValueQualityService.createMeasurementValueQuality(measurementValueQuality).then(res =>{
                this.props.history.push('/measurementValueQualitys');
            });
        }else{
            MeasurementValueQualityService.updateMeasurementValueQuality(measurementValueQuality).then( res => {
                this.props.history.push('/measurementValueQualitys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/measurementValueQualitys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MeasurementValueQuality</h3>
        }else{
            return <h3 className="text-center">Update MeasurementValueQuality</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMeasurementValueQuality}>Save</button>
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

export default CreateMeasurementValueQualityComponent
