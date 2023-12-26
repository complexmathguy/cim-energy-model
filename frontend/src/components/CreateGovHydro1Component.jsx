import React, { Component } from 'react'
import GovHydro1Service from '../services/GovHydro1Service';

class CreateGovHydro1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                at: '',
                dturb: '',
                gmax: '',
                gmin: '',
                hdam: '',
                mwbase: '',
                qnl: '',
                rperm: '',
                rtemp: '',
                tf: '',
                tg: '',
                tr: '',
                tw: '',
                velm: ''
        }
        this.changeatHandler = this.changeatHandler.bind(this);
        this.changedturbHandler = this.changedturbHandler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changehdamHandler = this.changehdamHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changeqnlHandler = this.changeqnlHandler.bind(this);
        this.changerpermHandler = this.changerpermHandler.bind(this);
        this.changertempHandler = this.changertempHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changevelmHandler = this.changevelmHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovHydro1Service.getGovHydro1ById(this.state.id).then( (res) =>{
                let govHydro1 = res.data;
                this.setState({
                    at: govHydro1.at,
                    dturb: govHydro1.dturb,
                    gmax: govHydro1.gmax,
                    gmin: govHydro1.gmin,
                    hdam: govHydro1.hdam,
                    mwbase: govHydro1.mwbase,
                    qnl: govHydro1.qnl,
                    rperm: govHydro1.rperm,
                    rtemp: govHydro1.rtemp,
                    tf: govHydro1.tf,
                    tg: govHydro1.tg,
                    tr: govHydro1.tr,
                    tw: govHydro1.tw,
                    velm: govHydro1.velm
                });
            });
        }        
    }
    saveOrUpdateGovHydro1 = (e) => {
        e.preventDefault();
        let govHydro1 = {
                govHydro1Id: this.state.id,
                at: this.state.at,
                dturb: this.state.dturb,
                gmax: this.state.gmax,
                gmin: this.state.gmin,
                hdam: this.state.hdam,
                mwbase: this.state.mwbase,
                qnl: this.state.qnl,
                rperm: this.state.rperm,
                rtemp: this.state.rtemp,
                tf: this.state.tf,
                tg: this.state.tg,
                tr: this.state.tr,
                tw: this.state.tw,
                velm: this.state.velm
            };
        console.log('govHydro1 => ' + JSON.stringify(govHydro1));

        // step 5
        if(this.state.id === '_add'){
            govHydro1.govHydro1Id=''
            GovHydro1Service.createGovHydro1(govHydro1).then(res =>{
                this.props.history.push('/govHydro1s');
            });
        }else{
            GovHydro1Service.updateGovHydro1(govHydro1).then( res => {
                this.props.history.push('/govHydro1s');
            });
        }
    }
    
    changeatHandler= (event) => {
        this.setState({at: event.target.value});
    }
    changedturbHandler= (event) => {
        this.setState({dturb: event.target.value});
    }
    changegmaxHandler= (event) => {
        this.setState({gmax: event.target.value});
    }
    changegminHandler= (event) => {
        this.setState({gmin: event.target.value});
    }
    changehdamHandler= (event) => {
        this.setState({hdam: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changeqnlHandler= (event) => {
        this.setState({qnl: event.target.value});
    }
    changerpermHandler= (event) => {
        this.setState({rperm: event.target.value});
    }
    changertempHandler= (event) => {
        this.setState({rtemp: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }
    changetwHandler= (event) => {
        this.setState({tw: event.target.value});
    }
    changevelmHandler= (event) => {
        this.setState({velm: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydro1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydro1</h3>
        }else{
            return <h3 className="text-center">Update GovHydro1</h3>
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
                                            <label> at: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dturb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> hdam: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qnl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rperm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rtemp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'create')
                                            <label> velm: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydro1}>Save</button>
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

export default CreateGovHydro1Component
