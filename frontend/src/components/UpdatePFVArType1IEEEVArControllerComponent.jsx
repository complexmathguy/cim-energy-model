import React, { Component } from 'react'
import PFVArType1IEEEVArControllerService from '../services/PFVArType1IEEEVArControllerService';

class UpdatePFVArType1IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                tvarc: '',
                vvar: '',
                vvarcbw: '',
                vvarref: '',
                vvtmax: '',
                vvtmin: ''
        }
        this.updatePFVArType1IEEEVArController = this.updatePFVArType1IEEEVArController.bind(this);

        this.changetvarcHandler = this.changetvarcHandler.bind(this);
        this.changevvarHandler = this.changevvarHandler.bind(this);
        this.changevvarcbwHandler = this.changevvarcbwHandler.bind(this);
        this.changevvarrefHandler = this.changevvarrefHandler.bind(this);
        this.changevvtmaxHandler = this.changevvtmaxHandler.bind(this);
        this.changevvtminHandler = this.changevvtminHandler.bind(this);
    }

    componentDidMount(){
        PFVArType1IEEEVArControllerService.getPFVArType1IEEEVArControllerById(this.state.id).then( (res) =>{
            let pFVArType1IEEEVArController = res.data;
            this.setState({
                tvarc: pFVArType1IEEEVArController.tvarc,
                vvar: pFVArType1IEEEVArController.vvar,
                vvarcbw: pFVArType1IEEEVArController.vvarcbw,
                vvarref: pFVArType1IEEEVArController.vvarref,
                vvtmax: pFVArType1IEEEVArController.vvtmax,
                vvtmin: pFVArType1IEEEVArController.vvtmin
            });
        });
    }

    updatePFVArType1IEEEVArController = (e) => {
        e.preventDefault();
        let pFVArType1IEEEVArController = {
            pFVArType1IEEEVArControllerId: this.state.id,
            tvarc: this.state.tvarc,
            vvar: this.state.vvar,
            vvarcbw: this.state.vvarcbw,
            vvarref: this.state.vvarref,
            vvtmax: this.state.vvtmax,
            vvtmin: this.state.vvtmin
        };
        console.log('pFVArType1IEEEVArController => ' + JSON.stringify(pFVArType1IEEEVArController));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType1IEEEVArControllerService.updatePFVArType1IEEEVArController(pFVArType1IEEEVArController).then( res => {
            this.props.history.push('/pFVArType1IEEEVArControllers');
        });
    }

    changetvarcHandler= (event) => {
        this.setState({tvarc: event.target.value});
    }
    changevvarHandler= (event) => {
        this.setState({vvar: event.target.value});
    }
    changevvarcbwHandler= (event) => {
        this.setState({vvarcbw: event.target.value});
    }
    changevvarrefHandler= (event) => {
        this.setState({vvarref: event.target.value});
    }
    changevvtmaxHandler= (event) => {
        this.setState({vvtmax: event.target.value});
    }
    changevvtminHandler= (event) => {
        this.setState({vvtmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArType1IEEEVArControllers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType1IEEEVArController</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> tvarc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vvar: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vvarcbw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vvarref: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vvtmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vvtmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType1IEEEVArController}>Save</button>
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

export default UpdatePFVArType1IEEEVArControllerComponent
