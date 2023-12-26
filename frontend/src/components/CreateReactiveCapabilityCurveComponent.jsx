import React, { Component } from 'react'
import ReactiveCapabilityCurveService from '../services/ReactiveCapabilityCurveService';

class CreateReactiveCapabilityCurveComponent extends Component {
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
            ReactiveCapabilityCurveService.getReactiveCapabilityCurveById(this.state.id).then( (res) =>{
                let reactiveCapabilityCurve = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateReactiveCapabilityCurve = (e) => {
        e.preventDefault();
        let reactiveCapabilityCurve = {
                reactiveCapabilityCurveId: this.state.id,
            };
        console.log('reactiveCapabilityCurve => ' + JSON.stringify(reactiveCapabilityCurve));

        // step 5
        if(this.state.id === '_add'){
            reactiveCapabilityCurve.reactiveCapabilityCurveId=''
            ReactiveCapabilityCurveService.createReactiveCapabilityCurve(reactiveCapabilityCurve).then(res =>{
                this.props.history.push('/reactiveCapabilityCurves');
            });
        }else{
            ReactiveCapabilityCurveService.updateReactiveCapabilityCurve(reactiveCapabilityCurve).then( res => {
                this.props.history.push('/reactiveCapabilityCurves');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/reactiveCapabilityCurves');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ReactiveCapabilityCurve</h3>
        }else{
            return <h3 className="text-center">Update ReactiveCapabilityCurve</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateReactiveCapabilityCurve}>Save</button>
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

export default CreateReactiveCapabilityCurveComponent
