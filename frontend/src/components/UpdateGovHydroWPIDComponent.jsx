import React, { Component } from 'react'
import GovHydroWPIDService from '../services/GovHydroWPIDService';

class UpdateGovHydroWPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                d: '',
                gatmax: '',
                gatmin: '',
                gv1: '',
                gv2: '',
                gv3: '',
                kd: '',
                ki: '',
                kp: '',
                mwbase: '',
                pgv1: '',
                pgv2: '',
                pgv3: '',
                pmax: '',
                pmin: '',
                reg: '',
                ta: '',
                tb: '',
                treg: '',
                tw: '',
                velmax: '',
                velmin: ''
        }
        this.updateGovHydroWPID = this.updateGovHydroWPID.bind(this);

        this.changedHandler = this.changedHandler.bind(this);
        this.changegatmaxHandler = this.changegatmaxHandler.bind(this);
        this.changegatminHandler = this.changegatminHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepgv1Handler = this.changepgv1Handler.bind(this);
        this.changepgv2Handler = this.changepgv2Handler.bind(this);
        this.changepgv3Handler = this.changepgv3Handler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changeregHandler = this.changeregHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetregHandler = this.changetregHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changevelmaxHandler = this.changevelmaxHandler.bind(this);
        this.changevelminHandler = this.changevelminHandler.bind(this);
    }

    componentDidMount(){
        GovHydroWPIDService.getGovHydroWPIDById(this.state.id).then( (res) =>{
            let govHydroWPID = res.data;
            this.setState({
                d: govHydroWPID.d,
                gatmax: govHydroWPID.gatmax,
                gatmin: govHydroWPID.gatmin,
                gv1: govHydroWPID.gv1,
                gv2: govHydroWPID.gv2,
                gv3: govHydroWPID.gv3,
                kd: govHydroWPID.kd,
                ki: govHydroWPID.ki,
                kp: govHydroWPID.kp,
                mwbase: govHydroWPID.mwbase,
                pgv1: govHydroWPID.pgv1,
                pgv2: govHydroWPID.pgv2,
                pgv3: govHydroWPID.pgv3,
                pmax: govHydroWPID.pmax,
                pmin: govHydroWPID.pmin,
                reg: govHydroWPID.reg,
                ta: govHydroWPID.ta,
                tb: govHydroWPID.tb,
                treg: govHydroWPID.treg,
                tw: govHydroWPID.tw,
                velmax: govHydroWPID.velmax,
                velmin: govHydroWPID.velmin
            });
        });
    }

    updateGovHydroWPID = (e) => {
        e.preventDefault();
        let govHydroWPID = {
            govHydroWPIDId: this.state.id,
            d: this.state.d,
            gatmax: this.state.gatmax,
            gatmin: this.state.gatmin,
            gv1: this.state.gv1,
            gv2: this.state.gv2,
            gv3: this.state.gv3,
            kd: this.state.kd,
            ki: this.state.ki,
            kp: this.state.kp,
            mwbase: this.state.mwbase,
            pgv1: this.state.pgv1,
            pgv2: this.state.pgv2,
            pgv3: this.state.pgv3,
            pmax: this.state.pmax,
            pmin: this.state.pmin,
            reg: this.state.reg,
            ta: this.state.ta,
            tb: this.state.tb,
            treg: this.state.treg,
            tw: this.state.tw,
            velmax: this.state.velmax,
            velmin: this.state.velmin
        };
        console.log('govHydroWPID => ' + JSON.stringify(govHydroWPID));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroWPIDService.updateGovHydroWPID(govHydroWPID).then( res => {
            this.props.history.push('/govHydroWPIDs');
        });
    }

    changedHandler= (event) => {
        this.setState({d: event.target.value});
    }
    changegatmaxHandler= (event) => {
        this.setState({gatmax: event.target.value});
    }
    changegatminHandler= (event) => {
        this.setState({gatmin: event.target.value});
    }
    changegv1Handler= (event) => {
        this.setState({gv1: event.target.value});
    }
    changegv2Handler= (event) => {
        this.setState({gv2: event.target.value});
    }
    changegv3Handler= (event) => {
        this.setState({gv3: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepgv1Handler= (event) => {
        this.setState({pgv1: event.target.value});
    }
    changepgv2Handler= (event) => {
        this.setState({pgv2: event.target.value});
    }
    changepgv3Handler= (event) => {
        this.setState({pgv3: event.target.value});
    }
    changepmaxHandler= (event) => {
        this.setState({pmax: event.target.value});
    }
    changepminHandler= (event) => {
        this.setState({pmin: event.target.value});
    }
    changeregHandler= (event) => {
        this.setState({reg: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetregHandler= (event) => {
        this.setState({treg: event.target.value});
    }
    changetwHandler= (event) => {
        this.setState({tw: event.target.value});
    }
    changevelmaxHandler= (event) => {
        this.setState({velmax: event.target.value});
    }
    changevelminHandler= (event) => {
        this.setState({velmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroWPIDs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroWPID</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> d: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gatmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gatmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> reg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> treg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> velmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> velmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroWPID}>Save</button>
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

export default UpdateGovHydroWPIDComponent
