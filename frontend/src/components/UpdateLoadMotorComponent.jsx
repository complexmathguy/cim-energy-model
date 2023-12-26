import React, { Component } from 'react'
import LoadMotorService from '../services/LoadMotorService';

class UpdateLoadMotorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                d: '',
                h: '',
                lfac: '',
                lp: '',
                lpp: '',
                ls: '',
                pfrac: '',
                ra: '',
                tbkr: '',
                tpo: '',
                tppo: '',
                tv: '',
                vt: ''
        }
        this.updateLoadMotor = this.updateLoadMotor.bind(this);

        this.changedHandler = this.changedHandler.bind(this);
        this.changehHandler = this.changehHandler.bind(this);
        this.changelfacHandler = this.changelfacHandler.bind(this);
        this.changelpHandler = this.changelpHandler.bind(this);
        this.changelppHandler = this.changelppHandler.bind(this);
        this.changelsHandler = this.changelsHandler.bind(this);
        this.changepfracHandler = this.changepfracHandler.bind(this);
        this.changeraHandler = this.changeraHandler.bind(this);
        this.changetbkrHandler = this.changetbkrHandler.bind(this);
        this.changetpoHandler = this.changetpoHandler.bind(this);
        this.changetppoHandler = this.changetppoHandler.bind(this);
        this.changetvHandler = this.changetvHandler.bind(this);
        this.changevtHandler = this.changevtHandler.bind(this);
    }

    componentDidMount(){
        LoadMotorService.getLoadMotorById(this.state.id).then( (res) =>{
            let loadMotor = res.data;
            this.setState({
                d: loadMotor.d,
                h: loadMotor.h,
                lfac: loadMotor.lfac,
                lp: loadMotor.lp,
                lpp: loadMotor.lpp,
                ls: loadMotor.ls,
                pfrac: loadMotor.pfrac,
                ra: loadMotor.ra,
                tbkr: loadMotor.tbkr,
                tpo: loadMotor.tpo,
                tppo: loadMotor.tppo,
                tv: loadMotor.tv,
                vt: loadMotor.vt
            });
        });
    }

    updateLoadMotor = (e) => {
        e.preventDefault();
        let loadMotor = {
            loadMotorId: this.state.id,
            d: this.state.d,
            h: this.state.h,
            lfac: this.state.lfac,
            lp: this.state.lp,
            lpp: this.state.lpp,
            ls: this.state.ls,
            pfrac: this.state.pfrac,
            ra: this.state.ra,
            tbkr: this.state.tbkr,
            tpo: this.state.tpo,
            tppo: this.state.tppo,
            tv: this.state.tv,
            vt: this.state.vt
        };
        console.log('loadMotor => ' + JSON.stringify(loadMotor));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadMotorService.updateLoadMotor(loadMotor).then( res => {
            this.props.history.push('/loadMotors');
        });
    }

    changedHandler= (event) => {
        this.setState({d: event.target.value});
    }
    changehHandler= (event) => {
        this.setState({h: event.target.value});
    }
    changelfacHandler= (event) => {
        this.setState({lfac: event.target.value});
    }
    changelpHandler= (event) => {
        this.setState({lp: event.target.value});
    }
    changelppHandler= (event) => {
        this.setState({lpp: event.target.value});
    }
    changelsHandler= (event) => {
        this.setState({ls: event.target.value});
    }
    changepfracHandler= (event) => {
        this.setState({pfrac: event.target.value});
    }
    changeraHandler= (event) => {
        this.setState({ra: event.target.value});
    }
    changetbkrHandler= (event) => {
        this.setState({tbkr: event.target.value});
    }
    changetpoHandler= (event) => {
        this.setState({tpo: event.target.value});
    }
    changetppoHandler= (event) => {
        this.setState({tppo: event.target.value});
    }
    changetvHandler= (event) => {
        this.setState({tv: event.target.value});
    }
    changevtHandler= (event) => {
        this.setState({vt: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadMotors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadMotor</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> d: </label>
                                            #formFields( $attribute, 'update')
                                            <label> h: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lfac: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lpp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ls: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pfrac: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ra: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tbkr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tppo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tv: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vt: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadMotor}>Save</button>
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

export default UpdateLoadMotorComponent
