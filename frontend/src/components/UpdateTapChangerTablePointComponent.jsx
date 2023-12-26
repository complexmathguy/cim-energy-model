import React, { Component } from 'react'
import TapChangerTablePointService from '../services/TapChangerTablePointService';

class UpdateTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                b: '',
                g: '',
                r: '',
                ratio: '',
                step: '',
                x: ''
        }
        this.updateTapChangerTablePoint = this.updateTapChangerTablePoint.bind(this);

        this.changebHandler = this.changebHandler.bind(this);
        this.changegHandler = this.changegHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changeratioHandler = this.changeratioHandler.bind(this);
        this.changestepHandler = this.changestepHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
    }

    componentDidMount(){
        TapChangerTablePointService.getTapChangerTablePointById(this.state.id).then( (res) =>{
            let tapChangerTablePoint = res.data;
            this.setState({
                b: tapChangerTablePoint.b,
                g: tapChangerTablePoint.g,
                r: tapChangerTablePoint.r,
                ratio: tapChangerTablePoint.ratio,
                step: tapChangerTablePoint.step,
                x: tapChangerTablePoint.x
            });
        });
    }

    updateTapChangerTablePoint = (e) => {
        e.preventDefault();
        let tapChangerTablePoint = {
            tapChangerTablePointId: this.state.id,
            b: this.state.b,
            g: this.state.g,
            r: this.state.r,
            ratio: this.state.ratio,
            step: this.state.step,
            x: this.state.x
        };
        console.log('tapChangerTablePoint => ' + JSON.stringify(tapChangerTablePoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        TapChangerTablePointService.updateTapChangerTablePoint(tapChangerTablePoint).then( res => {
            this.props.history.push('/tapChangerTablePoints');
        });
    }

    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changegHandler= (event) => {
        this.setState({g: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changeratioHandler= (event) => {
        this.setState({ratio: event.target.value});
    }
    changestepHandler= (event) => {
        this.setState({step: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }

    cancel(){
        this.props.history.push('/tapChangerTablePoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TapChangerTablePoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> b: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratio: </label>
                                            #formFields( $attribute, 'update')
                                            <label> step: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTapChangerTablePoint}>Save</button>
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

export default UpdateTapChangerTablePointComponent
