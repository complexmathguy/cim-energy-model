import React, { Component } from 'react'
import GrossToNetActivePowerCurveService from '../services/GrossToNetActivePowerCurveService';

class CreateGrossToNetActivePowerCurveComponent extends Component {
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
            GrossToNetActivePowerCurveService.getGrossToNetActivePowerCurveById(this.state.id).then( (res) =>{
                let grossToNetActivePowerCurve = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGrossToNetActivePowerCurve = (e) => {
        e.preventDefault();
        let grossToNetActivePowerCurve = {
                grossToNetActivePowerCurveId: this.state.id,
            };
        console.log('grossToNetActivePowerCurve => ' + JSON.stringify(grossToNetActivePowerCurve));

        // step 5
        if(this.state.id === '_add'){
            grossToNetActivePowerCurve.grossToNetActivePowerCurveId=''
            GrossToNetActivePowerCurveService.createGrossToNetActivePowerCurve(grossToNetActivePowerCurve).then(res =>{
                this.props.history.push('/grossToNetActivePowerCurves');
            });
        }else{
            GrossToNetActivePowerCurveService.updateGrossToNetActivePowerCurve(grossToNetActivePowerCurve).then( res => {
                this.props.history.push('/grossToNetActivePowerCurves');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/grossToNetActivePowerCurves');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GrossToNetActivePowerCurve</h3>
        }else{
            return <h3 className="text-center">Update GrossToNetActivePowerCurve</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGrossToNetActivePowerCurve}>Save</button>
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

export default CreateGrossToNetActivePowerCurveComponent
