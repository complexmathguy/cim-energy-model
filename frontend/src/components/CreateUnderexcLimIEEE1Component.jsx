import React, { Component } from 'react'
import UnderexcLimIEEE1Service from '../services/UnderexcLimIEEE1Service';

class CreateUnderexcLimIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
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

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateUnderexcLimIEEE1 = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            underexcLimIEEE1.underexcLimIEEE1Id=''
            UnderexcLimIEEE1Service.createUnderexcLimIEEE1(underexcLimIEEE1).then(res =>{
                this.props.history.push('/underexcLimIEEE1s');
            });
        }else{
            UnderexcLimIEEE1Service.updateUnderexcLimIEEE1(underexcLimIEEE1).then( res => {
                this.props.history.push('/underexcLimIEEE1s');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimIEEE1</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimIEEE1</h3>
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
                                            <label> kuc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kuf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kui: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kul: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kur: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vucmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vuimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vuimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vulmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vulmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vurmax: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimIEEE1}>Save</button>
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

export default CreateUnderexcLimIEEE1Component
