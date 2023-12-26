import React, { Component } from 'react'
import CurveDataService from '../services/CurveDataService';

class UpdateCurveDataComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                xvalue: '',
                y1value: '',
                y2value: ''
        }
        this.updateCurveData = this.updateCurveData.bind(this);

        this.changexvalueHandler = this.changexvalueHandler.bind(this);
        this.changey1valueHandler = this.changey1valueHandler.bind(this);
        this.changey2valueHandler = this.changey2valueHandler.bind(this);
    }

    componentDidMount(){
        CurveDataService.getCurveDataById(this.state.id).then( (res) =>{
            let curveData = res.data;
            this.setState({
                xvalue: curveData.xvalue,
                y1value: curveData.y1value,
                y2value: curveData.y2value
            });
        });
    }

    updateCurveData = (e) => {
        e.preventDefault();
        let curveData = {
            curveDataId: this.state.id,
            xvalue: this.state.xvalue,
            y1value: this.state.y1value,
            y2value: this.state.y2value
        };
        console.log('curveData => ' + JSON.stringify(curveData));
        console.log('id => ' + JSON.stringify(this.state.id));
        CurveDataService.updateCurveData(curveData).then( res => {
            this.props.history.push('/curveDatas');
        });
    }

    changexvalueHandler= (event) => {
        this.setState({xvalue: event.target.value});
    }
    changey1valueHandler= (event) => {
        this.setState({y1value: event.target.value});
    }
    changey2valueHandler= (event) => {
        this.setState({y2value: event.target.value});
    }

    cancel(){
        this.props.history.push('/curveDatas');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update CurveData</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> xvalue: </label>
                                            #formFields( $attribute, 'update')
                                            <label> y1value: </label>
                                            #formFields( $attribute, 'update')
                                            <label> y2value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCurveData}>Save</button>
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

export default UpdateCurveDataComponent
