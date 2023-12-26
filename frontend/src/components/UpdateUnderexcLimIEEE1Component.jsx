import React, { Component } from 'react'
import UnderexcLimIEEE1Service from '../services/UnderexcLimIEEE1Service';

class UpdateUnderexcLimIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kuc: '',
                kuf: '',
                kui: '',
                kul: '',
                kur: '',
                tu1: '',
                tu2: '',
                tu3: '',
                tu4: '',
                vucmax: '',
                vuimax: '',
                vuimin: '',
                vulmax: '',
                vulmin: '',
                vurmax: ''
        }
        this.updateUnderexcLimIEEE1 = this.updateUnderexcLimIEEE1.bind(this);

        this.changekucHandler = this.changekucHandler.bind(this);
        this.changekufHandler = this.changekufHandler.bind(this);
        this.changekuiHandler = this.changekuiHandler.bind(this);
        this.changekulHandler = this.changekulHandler.bind(this);
        this.changekurHandler = this.changekurHandler.bind(this);
        this.changetu1Handler = this.changetu1Handler.bind(this);
        this.changetu2Handler = this.changetu2Handler.bind(this);
        this.changetu3Handler = this.changetu3Handler.bind(this);
        this.changetu4Handler = this.changetu4Handler.bind(this);
        this.changevucmaxHandler = this.changevucmaxHandler.bind(this);
        this.changevuimaxHandler = this.changevuimaxHandler.bind(this);
        this.changevuiminHandler = this.changevuiminHandler.bind(this);
        this.changevulmaxHandler = this.changevulmaxHandler.bind(this);
        this.changevulminHandler = this.changevulminHandler.bind(this);
        this.changevurmaxHandler = this.changevurmaxHandler.bind(this);
    }

    componentDidMount(){
        UnderexcLimIEEE1Service.getUnderexcLimIEEE1ById(this.state.id).then( (res) =>{
            let underexcLimIEEE1 = res.data;
            this.setState({
                kuc: underexcLimIEEE1.kuc,
                kuf: underexcLimIEEE1.kuf,
                kui: underexcLimIEEE1.kui,
                kul: underexcLimIEEE1.kul,
                kur: underexcLimIEEE1.kur,
                tu1: underexcLimIEEE1.tu1,
                tu2: underexcLimIEEE1.tu2,
                tu3: underexcLimIEEE1.tu3,
                tu4: underexcLimIEEE1.tu4,
                vucmax: underexcLimIEEE1.vucmax,
                vuimax: underexcLimIEEE1.vuimax,
                vuimin: underexcLimIEEE1.vuimin,
                vulmax: underexcLimIEEE1.vulmax,
                vulmin: underexcLimIEEE1.vulmin,
                vurmax: underexcLimIEEE1.vurmax
            });
        });
    }

    updateUnderexcLimIEEE1 = (e) => {
        e.preventDefault();
        let underexcLimIEEE1 = {
            underexcLimIEEE1Id: this.state.id,
            kuc: this.state.kuc,
            kuf: this.state.kuf,
            kui: this.state.kui,
            kul: this.state.kul,
            kur: this.state.kur,
            tu1: this.state.tu1,
            tu2: this.state.tu2,
            tu3: this.state.tu3,
            tu4: this.state.tu4,
            vucmax: this.state.vucmax,
            vuimax: this.state.vuimax,
            vuimin: this.state.vuimin,
            vulmax: this.state.vulmax,
            vulmin: this.state.vulmin,
            vurmax: this.state.vurmax
        };
        console.log('underexcLimIEEE1 => ' + JSON.stringify(underexcLimIEEE1));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLimIEEE1Service.updateUnderexcLimIEEE1(underexcLimIEEE1).then( res => {
            this.props.history.push('/underexcLimIEEE1s');
        });
    }

    changekucHandler= (event) => {
        this.setState({kuc: event.target.value});
    }
    changekufHandler= (event) => {
        this.setState({kuf: event.target.value});
    }
    changekuiHandler= (event) => {
        this.setState({kui: event.target.value});
    }
    changekulHandler= (event) => {
        this.setState({kul: event.target.value});
    }
    changekurHandler= (event) => {
        this.setState({kur: event.target.value});
    }
    changetu1Handler= (event) => {
        this.setState({tu1: event.target.value});
    }
    changetu2Handler= (event) => {
        this.setState({tu2: event.target.value});
    }
    changetu3Handler= (event) => {
        this.setState({tu3: event.target.value});
    }
    changetu4Handler= (event) => {
        this.setState({tu4: event.target.value});
    }
    changevucmaxHandler= (event) => {
        this.setState({vucmax: event.target.value});
    }
    changevuimaxHandler= (event) => {
        this.setState({vuimax: event.target.value});
    }
    changevuiminHandler= (event) => {
        this.setState({vuimin: event.target.value});
    }
    changevulmaxHandler= (event) => {
        this.setState({vulmax: event.target.value});
    }
    changevulminHandler= (event) => {
        this.setState({vulmin: event.target.value});
    }
    changevurmaxHandler= (event) => {
        this.setState({vurmax: event.target.value});
    }

    cancel(){
        this.props.history.push('/underexcLimIEEE1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLimIEEE1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kuc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kuf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kui: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kul: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kur: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tu1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tu2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tu3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tu4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vucmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vuimax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vuimin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vulmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vulmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vurmax: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLimIEEE1}>Save</button>
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

export default UpdateUnderexcLimIEEE1Component
