import React, { Component } from 'react'
import ExcBBCService from '../services/ExcBBCService';

class CreateExcBBCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                efdmax: '',
                efdmin: '',
                k: '',
                switchIt: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                vrmax: '',
                vrmin: '',
                xe: ''
        }
        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changeswitchItHandler = this.changeswitchItHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changexeHandler = this.changexeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcBBCService.getExcBBCById(this.state.id).then( (res) =>{
                let excBBC = res.data;
                this.setState({
                    efdmax: excBBC.efdmax,
                    efdmin: excBBC.efdmin,
                    k: excBBC.k,
                    switchIt: excBBC.switchIt,
                    t1: excBBC.t1,
                    t2: excBBC.t2,
                    t3: excBBC.t3,
                    t4: excBBC.t4,
                    vrmax: excBBC.vrmax,
                    vrmin: excBBC.vrmin,
                    xe: excBBC.xe
                });
            });
        }        
    }
    saveOrUpdateExcBBC = (e) => {
        e.preventDefault();
        let excBBC = {
                excBBCId: this.state.id,
                efdmax: this.state.efdmax,
                efdmin: this.state.efdmin,
                k: this.state.k,
                switchIt: this.state.switchIt,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin,
                xe: this.state.xe
            };
        console.log('excBBC => ' + JSON.stringify(excBBC));

        // step 5
        if(this.state.id === '_add'){
            excBBC.excBBCId=''
            ExcBBCService.createExcBBC(excBBC).then(res =>{
                this.props.history.push('/excBBCs');
            });
        }else{
            ExcBBCService.updateExcBBC(excBBC).then( res => {
                this.props.history.push('/excBBCs');
            });
        }
    }
    
    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changeswitchItHandler= (event) => {
        this.setState({switchIt: event.target.value});
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
    changet4Handler= (event) => {
        this.setState({t4: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }
    changexeHandler= (event) => {
        this.setState({xe: event.target.value});
    }

    cancel(){
        this.props.history.push('/excBBCs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcBBC</h3>
        }else{
            return <h3 className="text-center">Update ExcBBC</h3>
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
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efdmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k: </label>
                                            #formFields( $attribute, 'create')
                                            <label> switchIt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xe: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcBBC}>Save</button>
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

export default CreateExcBBCComponent
