import React, { Component } from 'react'
import Pss5Service from '../services/Pss5Service';

class CreatePss5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ctw2: '',
                deadband: '',
                isfreq: '',
                kf: '',
                kpe: '',
                kpss: '',
                pmm: '',
                tl1: '',
                tl2: '',
                tl3: '',
                tl4: '',
                tpe: '',
                tw1: '',
                tw2: '',
                vadat: '',
                vsmn: '',
                vsmx: ''
        }
        this.changectw2Handler = this.changectw2Handler.bind(this);
        this.changedeadbandHandler = this.changedeadbandHandler.bind(this);
        this.changeisfreqHandler = this.changeisfreqHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekpeHandler = this.changekpeHandler.bind(this);
        this.changekpssHandler = this.changekpssHandler.bind(this);
        this.changepmmHandler = this.changepmmHandler.bind(this);
        this.changetl1Handler = this.changetl1Handler.bind(this);
        this.changetl2Handler = this.changetl2Handler.bind(this);
        this.changetl3Handler = this.changetl3Handler.bind(this);
        this.changetl4Handler = this.changetl4Handler.bind(this);
        this.changetpeHandler = this.changetpeHandler.bind(this);
        this.changetw1Handler = this.changetw1Handler.bind(this);
        this.changetw2Handler = this.changetw2Handler.bind(this);
        this.changevadatHandler = this.changevadatHandler.bind(this);
        this.changevsmnHandler = this.changevsmnHandler.bind(this);
        this.changevsmxHandler = this.changevsmxHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            Pss5Service.getPss5ById(this.state.id).then( (res) =>{
                let pss5 = res.data;
                this.setState({
                    ctw2: pss5.ctw2,
                    deadband: pss5.deadband,
                    isfreq: pss5.isfreq,
                    kf: pss5.kf,
                    kpe: pss5.kpe,
                    kpss: pss5.kpss,
                    pmm: pss5.pmm,
                    tl1: pss5.tl1,
                    tl2: pss5.tl2,
                    tl3: pss5.tl3,
                    tl4: pss5.tl4,
                    tpe: pss5.tpe,
                    tw1: pss5.tw1,
                    tw2: pss5.tw2,
                    vadat: pss5.vadat,
                    vsmn: pss5.vsmn,
                    vsmx: pss5.vsmx
                });
            });
        }        
    }
    saveOrUpdatePss5 = (e) => {
        e.preventDefault();
        let pss5 = {
                pss5Id: this.state.id,
                ctw2: this.state.ctw2,
                deadband: this.state.deadband,
                isfreq: this.state.isfreq,
                kf: this.state.kf,
                kpe: this.state.kpe,
                kpss: this.state.kpss,
                pmm: this.state.pmm,
                tl1: this.state.tl1,
                tl2: this.state.tl2,
                tl3: this.state.tl3,
                tl4: this.state.tl4,
                tpe: this.state.tpe,
                tw1: this.state.tw1,
                tw2: this.state.tw2,
                vadat: this.state.vadat,
                vsmn: this.state.vsmn,
                vsmx: this.state.vsmx
            };
        console.log('pss5 => ' + JSON.stringify(pss5));

        // step 5
        if(this.state.id === '_add'){
            pss5.pss5Id=''
            Pss5Service.createPss5(pss5).then(res =>{
                this.props.history.push('/pss5s');
            });
        }else{
            Pss5Service.updatePss5(pss5).then( res => {
                this.props.history.push('/pss5s');
            });
        }
    }
    
    changectw2Handler= (event) => {
        this.setState({ctw2: event.target.value});
    }
    changedeadbandHandler= (event) => {
        this.setState({deadband: event.target.value});
    }
    changeisfreqHandler= (event) => {
        this.setState({isfreq: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekpeHandler= (event) => {
        this.setState({kpe: event.target.value});
    }
    changekpssHandler= (event) => {
        this.setState({kpss: event.target.value});
    }
    changepmmHandler= (event) => {
        this.setState({pmm: event.target.value});
    }
    changetl1Handler= (event) => {
        this.setState({tl1: event.target.value});
    }
    changetl2Handler= (event) => {
        this.setState({tl2: event.target.value});
    }
    changetl3Handler= (event) => {
        this.setState({tl3: event.target.value});
    }
    changetl4Handler= (event) => {
        this.setState({tl4: event.target.value});
    }
    changetpeHandler= (event) => {
        this.setState({tpe: event.target.value});
    }
    changetw1Handler= (event) => {
        this.setState({tw1: event.target.value});
    }
    changetw2Handler= (event) => {
        this.setState({tw2: event.target.value});
    }
    changevadatHandler= (event) => {
        this.setState({vadat: event.target.value});
    }
    changevsmnHandler= (event) => {
        this.setState({vsmn: event.target.value});
    }
    changevsmxHandler= (event) => {
        this.setState({vsmx: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss5s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss5</h3>
        }else{
            return <h3 className="text-center">Update Pss5</h3>
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
                                            <label> ctw2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> deadband: </label>
                                            #formFields( $attribute, 'create')
                                            <label> isfreq: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpe: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpss: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpe: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vadat: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmx: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss5}>Save</button>
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

export default CreatePss5Component
