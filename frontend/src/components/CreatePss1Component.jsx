import React, { Component } from 'react'
import Pss1Service from '../services/Pss1Service';

class CreatePss1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kf: '',
                kpe: '',
                ks: '',
                kw: '',
                pmin: '',
                t10: '',
                t5: '',
                t6: '',
                t7: '',
                t8: '',
                t9: '',
                tpe: '',
                vadat: '',
                vsmn: '',
                vsmx: ''
        }
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekpeHandler = this.changekpeHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changekwHandler = this.changekwHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changet10Handler = this.changet10Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changet7Handler = this.changet7Handler.bind(this);
        this.changet8Handler = this.changet8Handler.bind(this);
        this.changet9Handler = this.changet9Handler.bind(this);
        this.changetpeHandler = this.changetpeHandler.bind(this);
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
            Pss1Service.getPss1ById(this.state.id).then( (res) =>{
                let pss1 = res.data;
                this.setState({
                    kf: pss1.kf,
                    kpe: pss1.kpe,
                    ks: pss1.ks,
                    kw: pss1.kw,
                    pmin: pss1.pmin,
                    t10: pss1.t10,
                    t5: pss1.t5,
                    t6: pss1.t6,
                    t7: pss1.t7,
                    t8: pss1.t8,
                    t9: pss1.t9,
                    tpe: pss1.tpe,
                    vadat: pss1.vadat,
                    vsmn: pss1.vsmn,
                    vsmx: pss1.vsmx
                });
            });
        }        
    }
    saveOrUpdatePss1 = (e) => {
        e.preventDefault();
        let pss1 = {
                pss1Id: this.state.id,
                kf: this.state.kf,
                kpe: this.state.kpe,
                ks: this.state.ks,
                kw: this.state.kw,
                pmin: this.state.pmin,
                t10: this.state.t10,
                t5: this.state.t5,
                t6: this.state.t6,
                t7: this.state.t7,
                t8: this.state.t8,
                t9: this.state.t9,
                tpe: this.state.tpe,
                vadat: this.state.vadat,
                vsmn: this.state.vsmn,
                vsmx: this.state.vsmx
            };
        console.log('pss1 => ' + JSON.stringify(pss1));

        // step 5
        if(this.state.id === '_add'){
            pss1.pss1Id=''
            Pss1Service.createPss1(pss1).then(res =>{
                this.props.history.push('/pss1s');
            });
        }else{
            Pss1Service.updatePss1(pss1).then( res => {
                this.props.history.push('/pss1s');
            });
        }
    }
    
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekpeHandler= (event) => {
        this.setState({kpe: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changekwHandler= (event) => {
        this.setState({kw: event.target.value});
    }
    changepminHandler= (event) => {
        this.setState({pmin: event.target.value});
    }
    changet10Handler= (event) => {
        this.setState({t10: event.target.value});
    }
    changet5Handler= (event) => {
        this.setState({t5: event.target.value});
    }
    changet6Handler= (event) => {
        this.setState({t6: event.target.value});
    }
    changet7Handler= (event) => {
        this.setState({t7: event.target.value});
    }
    changet8Handler= (event) => {
        this.setState({t8: event.target.value});
    }
    changet9Handler= (event) => {
        this.setState({t9: event.target.value});
    }
    changetpeHandler= (event) => {
        this.setState({tpe: event.target.value});
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
        this.props.history.push('/pss1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss1</h3>
        }else{
            return <h3 className="text-center">Update Pss1</h3>
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
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpe: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kw: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpe: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vadat: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmx: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss1}>Save</button>
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

export default CreatePss1Component
