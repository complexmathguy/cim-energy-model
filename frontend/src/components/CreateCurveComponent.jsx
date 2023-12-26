import React, { Component } from 'react'
import CurveService from '../services/CurveService';

class CreateCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                curveStyle: '',
                xUnit: '',
                y1Unit: '',
                y2Unit: ''
        }
        this.changecurveStyleHandler = this.changecurveStyleHandler.bind(this);
        this.changexUnitHandler = this.changexUnitHandler.bind(this);
        this.changey1UnitHandler = this.changey1UnitHandler.bind(this);
        this.changey2UnitHandler = this.changey2UnitHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CurveService.getCurveById(this.state.id).then( (res) =>{
                let curve = res.data;
                this.setState({
                    curveStyle: curve.curveStyle,
                    xUnit: curve.xUnit,
                    y1Unit: curve.y1Unit,
                    y2Unit: curve.y2Unit
                });
            });
        }        
    }
    saveOrUpdateCurve = (e) => {
        e.preventDefault();
        let curve = {
                curveId: this.state.id,
                curveStyle: this.state.curveStyle,
                xUnit: this.state.xUnit,
                y1Unit: this.state.y1Unit,
                y2Unit: this.state.y2Unit
            };
        console.log('curve => ' + JSON.stringify(curve));

        // step 5
        if(this.state.id === '_add'){
            curve.curveId=''
            CurveService.createCurve(curve).then(res =>{
                this.props.history.push('/curves');
            });
        }else{
            CurveService.updateCurve(curve).then( res => {
                this.props.history.push('/curves');
            });
        }
    }
    
    changecurveStyleHandler= (event) => {
        this.setState({curveStyle: event.target.value});
    }
    changexUnitHandler= (event) => {
        this.setState({xUnit: event.target.value});
    }
    changey1UnitHandler= (event) => {
        this.setState({y1Unit: event.target.value});
    }
    changey2UnitHandler= (event) => {
        this.setState({y2Unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/curves');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Curve</h3>
        }else{
            return <h3 className="text-center">Update Curve</h3>
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
                                            <label> curveStyle: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xUnit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> y1Unit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> y2Unit: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCurve}>Save</button>
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

export default CreateCurveComponent
