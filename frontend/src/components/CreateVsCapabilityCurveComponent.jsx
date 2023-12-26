import React, { Component } from 'react'
import VsCapabilityCurveService from '../services/VsCapabilityCurveService';

class CreateVsCapabilityCurveComponent extends Component {
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
            VsCapabilityCurveService.getVsCapabilityCurveById(this.state.id).then( (res) =>{
                let vsCapabilityCurve = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateVsCapabilityCurve = (e) => {
        e.preventDefault();
        let vsCapabilityCurve = {
                vsCapabilityCurveId: this.state.id,
            };
        console.log('vsCapabilityCurve => ' + JSON.stringify(vsCapabilityCurve));

        // step 5
        if(this.state.id === '_add'){
            vsCapabilityCurve.vsCapabilityCurveId=''
            VsCapabilityCurveService.createVsCapabilityCurve(vsCapabilityCurve).then(res =>{
                this.props.history.push('/vsCapabilityCurves');
            });
        }else{
            VsCapabilityCurveService.updateVsCapabilityCurve(vsCapabilityCurve).then( res => {
                this.props.history.push('/vsCapabilityCurves');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/vsCapabilityCurves');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VsCapabilityCurve</h3>
        }else{
            return <h3 className="text-center">Update VsCapabilityCurve</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVsCapabilityCurve}>Save</button>
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

export default CreateVsCapabilityCurveComponent
