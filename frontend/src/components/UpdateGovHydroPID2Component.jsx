import React, { Component } from 'react'
import GovHydroPID2Service from '../services/GovHydroPID2Service';

class UpdateGovHydroPID2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                atw: '',
                d: '',
                feedbackSignal: '',
                g0: '',
                g1: '',
                g2: '',
                gmax: '',
                gmin: '',
                kd: '',
                ki: '',
                kp: '',
                mwbase: '',
                p1: '',
                p2: '',
                p3: '',
                rperm: '',
                ta: '',
                tb: '',
                treg: '',
                tw: '',
                velmax: '',
                velmin: ''
        }
        this.updateGovHydroPID2 = this.updateGovHydroPID2.bind(this);

        this.changeatwHandler = this.changeatwHandler.bind(this);
        this.changedHandler = this.changedHandler.bind(this);
        this.changefeedbackSignalHandler = this.changefeedbackSignalHandler.bind(this);
        this.changeg0Handler = this.changeg0Handler.bind(this);
        this.changeg1Handler = this.changeg1Handler.bind(this);
        this.changeg2Handler = this.changeg2Handler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changep1Handler = this.changep1Handler.bind(this);
        this.changep2Handler = this.changep2Handler.bind(this);
        this.changep3Handler = this.changep3Handler.bind(this);
        this.changerpermHandler = this.changerpermHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetregHandler = this.changetregHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changevelmaxHandler = this.changevelmaxHandler.bind(this);
        this.changevelminHandler = this.changevelminHandler.bind(this);
    }

    componentDidMount(){
        GovHydroPID2Service.getGovHydroPID2ById(this.state.id).then( (res) =>{
            let govHydroPID2 = res.data;
            this.setState({
                atw: govHydroPID2.atw,
                d: govHydroPID2.d,
                feedbackSignal: govHydroPID2.feedbackSignal,
                g0: govHydroPID2.g0,
                g1: govHydroPID2.g1,
                g2: govHydroPID2.g2,
                gmax: govHydroPID2.gmax,
                gmin: govHydroPID2.gmin,
                kd: govHydroPID2.kd,
                ki: govHydroPID2.ki,
                kp: govHydroPID2.kp,
                mwbase: govHydroPID2.mwbase,
                p1: govHydroPID2.p1,
                p2: govHydroPID2.p2,
                p3: govHydroPID2.p3,
                rperm: govHydroPID2.rperm,
                ta: govHydroPID2.ta,
                tb: govHydroPID2.tb,
                treg: govHydroPID2.treg,
                tw: govHydroPID2.tw,
                velmax: govHydroPID2.velmax,
                velmin: govHydroPID2.velmin
            });
        });
    }

    updateGovHydroPID2 = (e) => {
        e.preventDefault();
        let govHydroPID2 = {
            govHydroPID2Id: this.state.id,
            atw: this.state.atw,
            d: this.state.d,
            feedbackSignal: this.state.feedbackSignal,
            g0: this.state.g0,
            g1: this.state.g1,
            g2: this.state.g2,
            gmax: this.state.gmax,
            gmin: this.state.gmin,
            kd: this.state.kd,
            ki: this.state.ki,
            kp: this.state.kp,
            mwbase: this.state.mwbase,
            p1: this.state.p1,
            p2: this.state.p2,
            p3: this.state.p3,
            rperm: this.state.rperm,
            ta: this.state.ta,
            tb: this.state.tb,
            treg: this.state.treg,
            tw: this.state.tw,
            velmax: this.state.velmax,
            velmin: this.state.velmin
        };
        console.log('govHydroPID2 => ' + JSON.stringify(govHydroPID2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroPID2Service.updateGovHydroPID2(govHydroPID2).then( res => {
            this.props.history.push('/govHydroPID2s');
        });
    }

    changeatwHandler= (event) => {
        this.setState({atw: event.target.value});
    }
    changedHandler= (event) => {
        this.setState({d: event.target.value});
    }
    changefeedbackSignalHandler= (event) => {
        this.setState({feedbackSignal: event.target.value});
    }
    changeg0Handler= (event) => {
        this.setState({g0: event.target.value});
    }
    changeg1Handler= (event) => {
        this.setState({g1: event.target.value});
    }
    changeg2Handler= (event) => {
        this.setState({g2: event.target.value});
    }
    changegmaxHandler= (event) => {
        this.setState({gmax: event.target.value});
    }
    changegminHandler= (event) => {
        this.setState({gmin: event.target.value});
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
    changep1Handler= (event) => {
        this.setState({p1: event.target.value});
    }
    changep2Handler= (event) => {
        this.setState({p2: event.target.value});
    }
    changep3Handler= (event) => {
        this.setState({p3: event.target.value});
    }
    changerpermHandler= (event) => {
        this.setState({rperm: event.target.value});
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
        this.props.history.push('/govHydroPID2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroPID2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> atw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> d: </label>
                                            #formFields( $attribute, 'update')
                                            <label> feedbackSignal: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> p1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> p2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> p3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rperm: </label>
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
                                        <button className="btn btn-success" onClick={this.updateGovHydroPID2}>Save</button>
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

export default UpdateGovHydroPID2Component
