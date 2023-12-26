import React, { Component } from 'react'
import VsCapabilityCurveService from '../services/VsCapabilityCurveService';

class UpdateVsCapabilityCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateVsCapabilityCurve = this.updateVsCapabilityCurve.bind(this);

    }

    componentDidMount(){
        VsCapabilityCurveService.getVsCapabilityCurveById(this.state.id).then( (res) =>{
            let vsCapabilityCurve = res.data;
            this.setState({
            });
        });
    }

    updateVsCapabilityCurve = (e) => {
        e.preventDefault();
        let vsCapabilityCurve = {
            vsCapabilityCurveId: this.state.id,
        };
        console.log('vsCapabilityCurve => ' + JSON.stringify(vsCapabilityCurve));
        console.log('id => ' + JSON.stringify(this.state.id));
        VsCapabilityCurveService.updateVsCapabilityCurve(vsCapabilityCurve).then( res => {
            this.props.history.push('/vsCapabilityCurves');
        });
    }


    cancel(){
        this.props.history.push('/vsCapabilityCurves');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VsCapabilityCurve</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVsCapabilityCurve}>Save</button>
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

export default UpdateVsCapabilityCurveComponent
