import React, { Component } from 'react'
import WindContQIECService from '../services/WindContQIECService';

class CreateWindContQIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                iqh1: '',
                iqmax: '',
                iqmin: '',
                iqpost: '',
                kiq: '',
                kiu: '',
                kpq: '',
                kpu: '',
                kqv: '',
                qmax: '',
                qmin: '',
                rdroop: '',
                tiq: '',
                tpfilt: '',
                tpost: '',
                tqord: '',
                tufilt: '',
                udb1: '',
                udb2: '',
                umax: '',
                umin: '',
                uqdip: '',
                uref0: '',
                windLVRTQcontrolModesType: '',
                windQcontrolModesType: '',
                xdroop: ''
        }
        this.changeiqh1Handler = this.changeiqh1Handler.bind(this);
        this.changeiqmaxHandler = this.changeiqmaxHandler.bind(this);
        this.changeiqminHandler = this.changeiqminHandler.bind(this);
        this.changeiqpostHandler = this.changeiqpostHandler.bind(this);
        this.changekiqHandler = this.changekiqHandler.bind(this);
        this.changekiuHandler = this.changekiuHandler.bind(this);
        this.changekpqHandler = this.changekpqHandler.bind(this);
        this.changekpuHandler = this.changekpuHandler.bind(this);
        this.changekqvHandler = this.changekqvHandler.bind(this);
        this.changeqmaxHandler = this.changeqmaxHandler.bind(this);
        this.changeqminHandler = this.changeqminHandler.bind(this);
        this.changerdroopHandler = this.changerdroopHandler.bind(this);
        this.changetiqHandler = this.changetiqHandler.bind(this);
        this.changetpfiltHandler = this.changetpfiltHandler.bind(this);
        this.changetpostHandler = this.changetpostHandler.bind(this);
        this.changetqordHandler = this.changetqordHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
        this.changeudb1Handler = this.changeudb1Handler.bind(this);
        this.changeudb2Handler = this.changeudb2Handler.bind(this);
        this.changeumaxHandler = this.changeumaxHandler.bind(this);
        this.changeuminHandler = this.changeuminHandler.bind(this);
        this.changeuqdipHandler = this.changeuqdipHandler.bind(this);
        this.changeuref0Handler = this.changeuref0Handler.bind(this);
        this.changewindLVRTQcontrolModesTypeHandler = this.changewindLVRTQcontrolModesTypeHandler.bind(this);
        this.changewindQcontrolModesTypeHandler = this.changewindQcontrolModesTypeHandler.bind(this);
        this.changexdroopHandler = this.changexdroopHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindContQIECService.getWindContQIECById(this.state.id).then( (res) =>{
                let windContQIEC = res.data;
                this.setState({
                    iqh1: windContQIEC.iqh1,
                    iqmax: windContQIEC.iqmax,
                    iqmin: windContQIEC.iqmin,
                    iqpost: windContQIEC.iqpost,
                    kiq: windContQIEC.kiq,
                    kiu: windContQIEC.kiu,
                    kpq: windContQIEC.kpq,
                    kpu: windContQIEC.kpu,
                    kqv: windContQIEC.kqv,
                    qmax: windContQIEC.qmax,
                    qmin: windContQIEC.qmin,
                    rdroop: windContQIEC.rdroop,
                    tiq: windContQIEC.tiq,
                    tpfilt: windContQIEC.tpfilt,
                    tpost: windContQIEC.tpost,
                    tqord: windContQIEC.tqord,
                    tufilt: windContQIEC.tufilt,
                    udb1: windContQIEC.udb1,
                    udb2: windContQIEC.udb2,
                    umax: windContQIEC.umax,
                    umin: windContQIEC.umin,
                    uqdip: windContQIEC.uqdip,
                    uref0: windContQIEC.uref0,
                    windLVRTQcontrolModesType: windContQIEC.windLVRTQcontrolModesType,
                    windQcontrolModesType: windContQIEC.windQcontrolModesType,
                    xdroop: windContQIEC.xdroop
                });
            });
        }        
    }
    saveOrUpdateWindContQIEC = (e) => {
        e.preventDefault();
        let windContQIEC = {
                windContQIECId: this.state.id,
                iqh1: this.state.iqh1,
                iqmax: this.state.iqmax,
                iqmin: this.state.iqmin,
                iqpost: this.state.iqpost,
                kiq: this.state.kiq,
                kiu: this.state.kiu,
                kpq: this.state.kpq,
                kpu: this.state.kpu,
                kqv: this.state.kqv,
                qmax: this.state.qmax,
                qmin: this.state.qmin,
                rdroop: this.state.rdroop,
                tiq: this.state.tiq,
                tpfilt: this.state.tpfilt,
                tpost: this.state.tpost,
                tqord: this.state.tqord,
                tufilt: this.state.tufilt,
                udb1: this.state.udb1,
                udb2: this.state.udb2,
                umax: this.state.umax,
                umin: this.state.umin,
                uqdip: this.state.uqdip,
                uref0: this.state.uref0,
                windLVRTQcontrolModesType: this.state.windLVRTQcontrolModesType,
                windQcontrolModesType: this.state.windQcontrolModesType,
                xdroop: this.state.xdroop
            };
        console.log('windContQIEC => ' + JSON.stringify(windContQIEC));

        // step 5
        if(this.state.id === '_add'){
            windContQIEC.windContQIECId=''
            WindContQIECService.createWindContQIEC(windContQIEC).then(res =>{
                this.props.history.push('/windContQIECs');
            });
        }else{
            WindContQIECService.updateWindContQIEC(windContQIEC).then( res => {
                this.props.history.push('/windContQIECs');
            });
        }
    }
    
    changeiqh1Handler= (event) => {
        this.setState({iqh1: event.target.value});
    }
    changeiqmaxHandler= (event) => {
        this.setState({iqmax: event.target.value});
    }
    changeiqminHandler= (event) => {
        this.setState({iqmin: event.target.value});
    }
    changeiqpostHandler= (event) => {
        this.setState({iqpost: event.target.value});
    }
    changekiqHandler= (event) => {
        this.setState({kiq: event.target.value});
    }
    changekiuHandler= (event) => {
        this.setState({kiu: event.target.value});
    }
    changekpqHandler= (event) => {
        this.setState({kpq: event.target.value});
    }
    changekpuHandler= (event) => {
        this.setState({kpu: event.target.value});
    }
    changekqvHandler= (event) => {
        this.setState({kqv: event.target.value});
    }
    changeqmaxHandler= (event) => {
        this.setState({qmax: event.target.value});
    }
    changeqminHandler= (event) => {
        this.setState({qmin: event.target.value});
    }
    changerdroopHandler= (event) => {
        this.setState({rdroop: event.target.value});
    }
    changetiqHandler= (event) => {
        this.setState({tiq: event.target.value});
    }
    changetpfiltHandler= (event) => {
        this.setState({tpfilt: event.target.value});
    }
    changetpostHandler= (event) => {
        this.setState({tpost: event.target.value});
    }
    changetqordHandler= (event) => {
        this.setState({tqord: event.target.value});
    }
    changetufiltHandler= (event) => {
        this.setState({tufilt: event.target.value});
    }
    changeudb1Handler= (event) => {
        this.setState({udb1: event.target.value});
    }
    changeudb2Handler= (event) => {
        this.setState({udb2: event.target.value});
    }
    changeumaxHandler= (event) => {
        this.setState({umax: event.target.value});
    }
    changeuminHandler= (event) => {
        this.setState({umin: event.target.value});
    }
    changeuqdipHandler= (event) => {
        this.setState({uqdip: event.target.value});
    }
    changeuref0Handler= (event) => {
        this.setState({uref0: event.target.value});
    }
    changewindLVRTQcontrolModesTypeHandler= (event) => {
        this.setState({windLVRTQcontrolModesType: event.target.value});
    }
    changewindQcontrolModesTypeHandler= (event) => {
        this.setState({windQcontrolModesType: event.target.value});
    }
    changexdroopHandler= (event) => {
        this.setState({xdroop: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContQIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContQIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContQIEC</h3>
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
                                            <label> iqh1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> iqmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> iqmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> iqpost: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kiq: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kiu: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpq: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpu: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kqv: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rdroop: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tiq: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpfilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpost: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tqord: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> udb1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> udb2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> umax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> umin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uqdip: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uref0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> windLVRTQcontrolModesType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> windQcontrolModesType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xdroop: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContQIEC}>Save</button>
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

export default CreateWindContQIECComponent
