import React, { Component } from 'react'
import ExcANSService from '../services/ExcANSService';

class CreateExcANSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                blint: '',
                ifmn: '',
                ifmx: '',
                k2: '',
                k3: '',
                kce: '',
                krvecc: '',
                kvfif: '',
                t1: '',
                t2: '',
                t3: '',
                tb: '',
                vrmn: '',
                vrmx: ''
        }
        this.changeblintHandler = this.changeblintHandler.bind(this);
        this.changeifmnHandler = this.changeifmnHandler.bind(this);
        this.changeifmxHandler = this.changeifmxHandler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changekceHandler = this.changekceHandler.bind(this);
        this.changekrveccHandler = this.changekrveccHandler.bind(this);
        this.changekvfifHandler = this.changekvfifHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changevrmnHandler = this.changevrmnHandler.bind(this);
        this.changevrmxHandler = this.changevrmxHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcANSService.getExcANSById(this.state.id).then( (res) =>{
                let excANS = res.data;
                this.setState({
                    blint: excANS.blint,
                    ifmn: excANS.ifmn,
                    ifmx: excANS.ifmx,
                    k2: excANS.k2,
                    k3: excANS.k3,
                    kce: excANS.kce,
                    krvecc: excANS.krvecc,
                    kvfif: excANS.kvfif,
                    t1: excANS.t1,
                    t2: excANS.t2,
                    t3: excANS.t3,
                    tb: excANS.tb,
                    vrmn: excANS.vrmn,
                    vrmx: excANS.vrmx
                });
            });
        }        
    }
    saveOrUpdateExcANS = (e) => {
        e.preventDefault();
        let excANS = {
                excANSId: this.state.id,
                blint: this.state.blint,
                ifmn: this.state.ifmn,
                ifmx: this.state.ifmx,
                k2: this.state.k2,
                k3: this.state.k3,
                kce: this.state.kce,
                krvecc: this.state.krvecc,
                kvfif: this.state.kvfif,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                tb: this.state.tb,
                vrmn: this.state.vrmn,
                vrmx: this.state.vrmx
            };
        console.log('excANS => ' + JSON.stringify(excANS));

        // step 5
        if(this.state.id === '_add'){
            excANS.excANSId=''
            ExcANSService.createExcANS(excANS).then(res =>{
                this.props.history.push('/excANSs');
            });
        }else{
            ExcANSService.updateExcANS(excANS).then( res => {
                this.props.history.push('/excANSs');
            });
        }
    }
    
    changeblintHandler= (event) => {
        this.setState({blint: event.target.value});
    }
    changeifmnHandler= (event) => {
        this.setState({ifmn: event.target.value});
    }
    changeifmxHandler= (event) => {
        this.setState({ifmx: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changek3Handler= (event) => {
        this.setState({k3: event.target.value});
    }
    changekceHandler= (event) => {
        this.setState({kce: event.target.value});
    }
    changekrveccHandler= (event) => {
        this.setState({krvecc: event.target.value});
    }
    changekvfifHandler= (event) => {
        this.setState({kvfif: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
    }
    changet3Handler= (event) => {
        this.setState({t3: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changevrmnHandler= (event) => {
        this.setState({vrmn: event.target.value});
    }
    changevrmxHandler= (event) => {
        this.setState({vrmx: event.target.value});
    }

    cancel(){
        this.props.history.push('/excANSs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcANS</h3>
        }else{
            return <h3 className="text-center">Update ExcANS</h3>
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
                                            <label> blint: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ifmn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ifmx: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kce: </label>
                                            #formFields( $attribute, 'create')
                                            <label> krvecc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kvfif: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmx: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcANS}>Save</button>
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

export default CreateExcANSComponent
