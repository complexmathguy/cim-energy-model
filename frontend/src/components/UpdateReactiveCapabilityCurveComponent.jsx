import React, { Component } from 'react'
import ReactiveCapabilityCurveService from '../services/ReactiveCapabilityCurveService';

class UpdateReactiveCapabilityCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateReactiveCapabilityCurve = this.updateReactiveCapabilityCurve.bind(this);

    }

    componentDidMount(){
        ReactiveCapabilityCurveService.getReactiveCapabilityCurveById(this.state.id).then( (res) =>{
            let reactiveCapabilityCurve = res.data;
            this.setState({
            });
        });
    }

    updateReactiveCapabilityCurve = (e) => {
        e.preventDefault();
        let reactiveCapabilityCurve = {
            reactiveCapabilityCurveId: this.state.id,
        };
        console.log('reactiveCapabilityCurve => ' + JSON.stringify(reactiveCapabilityCurve));
        console.log('id => ' + JSON.stringify(this.state.id));
        ReactiveCapabilityCurveService.updateReactiveCapabilityCurve(reactiveCapabilityCurve).then( res => {
            this.props.history.push('/reactiveCapabilityCurves');
        });
    }


    cancel(){
        this.props.history.push('/reactiveCapabilityCurves');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ReactiveCapabilityCurve</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateReactiveCapabilityCurve}>Save</button>
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

export default UpdateReactiveCapabilityCurveComponent
