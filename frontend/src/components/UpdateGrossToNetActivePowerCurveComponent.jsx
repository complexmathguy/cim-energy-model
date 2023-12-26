import React, { Component } from 'react'
import GrossToNetActivePowerCurveService from '../services/GrossToNetActivePowerCurveService';

class UpdateGrossToNetActivePowerCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGrossToNetActivePowerCurve = this.updateGrossToNetActivePowerCurve.bind(this);

    }

    componentDidMount(){
        GrossToNetActivePowerCurveService.getGrossToNetActivePowerCurveById(this.state.id).then( (res) =>{
            let grossToNetActivePowerCurve = res.data;
            this.setState({
            });
        });
    }

    updateGrossToNetActivePowerCurve = (e) => {
        e.preventDefault();
        let grossToNetActivePowerCurve = {
            grossToNetActivePowerCurveId: this.state.id,
        };
        console.log('grossToNetActivePowerCurve => ' + JSON.stringify(grossToNetActivePowerCurve));
        console.log('id => ' + JSON.stringify(this.state.id));
        GrossToNetActivePowerCurveService.updateGrossToNetActivePowerCurve(grossToNetActivePowerCurve).then( res => {
            this.props.history.push('/grossToNetActivePowerCurves');
        });
    }


    cancel(){
        this.props.history.push('/grossToNetActivePowerCurves');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GrossToNetActivePowerCurve</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGrossToNetActivePowerCurve}>Save</button>
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

export default UpdateGrossToNetActivePowerCurveComponent
