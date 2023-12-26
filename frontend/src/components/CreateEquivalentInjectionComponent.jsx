import React, { Component } from 'react'
import EquivalentInjectionService from '../services/EquivalentInjectionService';

class CreateEquivalentInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                maxP: '',
                maxQ: '',
                minP: '',
                minQ: '',
                r: '',
                r0: '',
                r2: '',
                regulationCapability: '',
                x: '',
                x0: '',
                x2: ''
        }
        this.changemaxPHandler = this.changemaxPHandler.bind(this);
        this.changemaxQHandler = this.changemaxQHandler.bind(this);
        this.changeminPHandler = this.changeminPHandler.bind(this);
        this.changeminQHandler = this.changeminQHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changer2Handler = this.changer2Handler.bind(this);
        this.changeregulationCapabilityHandler = this.changeregulationCapabilityHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
        this.changex2Handler = this.changex2Handler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EquivalentInjectionService.getEquivalentInjectionById(this.state.id).then( (res) =>{
                let equivalentInjection = res.data;
                this.setState({
                    maxP: equivalentInjection.maxP,
                    maxQ: equivalentInjection.maxQ,
                    minP: equivalentInjection.minP,
                    minQ: equivalentInjection.minQ,
                    r: equivalentInjection.r,
                    r0: equivalentInjection.r0,
                    r2: equivalentInjection.r2,
                    regulationCapability: equivalentInjection.regulationCapability,
                    x: equivalentInjection.x,
                    x0: equivalentInjection.x0,
                    x2: equivalentInjection.x2
                });
            });
        }        
    }
    saveOrUpdateEquivalentInjection = (e) => {
        e.preventDefault();
        let equivalentInjection = {
                equivalentInjectionId: this.state.id,
                maxP: this.state.maxP,
                maxQ: this.state.maxQ,
                minP: this.state.minP,
                minQ: this.state.minQ,
                r: this.state.r,
                r0: this.state.r0,
                r2: this.state.r2,
                regulationCapability: this.state.regulationCapability,
                x: this.state.x,
                x0: this.state.x0,
                x2: this.state.x2
            };
        console.log('equivalentInjection => ' + JSON.stringify(equivalentInjection));

        // step 5
        if(this.state.id === '_add'){
            equivalentInjection.equivalentInjectionId=''
            EquivalentInjectionService.createEquivalentInjection(equivalentInjection).then(res =>{
                this.props.history.push('/equivalentInjections');
            });
        }else{
            EquivalentInjectionService.updateEquivalentInjection(equivalentInjection).then( res => {
                this.props.history.push('/equivalentInjections');
            });
        }
    }
    
    changemaxPHandler= (event) => {
        this.setState({maxP: event.target.value});
    }
    changemaxQHandler= (event) => {
        this.setState({maxQ: event.target.value});
    }
    changeminPHandler= (event) => {
        this.setState({minP: event.target.value});
    }
    changeminQHandler= (event) => {
        this.setState({minQ: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changer0Handler= (event) => {
        this.setState({r0: event.target.value});
    }
    changer2Handler= (event) => {
        this.setState({r2: event.target.value});
    }
    changeregulationCapabilityHandler= (event) => {
        this.setState({regulationCapability: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }
    changex0Handler= (event) => {
        this.setState({x0: event.target.value});
    }
    changex2Handler= (event) => {
        this.setState({x2: event.target.value});
    }

    cancel(){
        this.props.history.push('/equivalentInjections');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquivalentInjection</h3>
        }else{
            return <h3 className="text-center">Update EquivalentInjection</h3>
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
                                            <label> maxP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxQ: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minQ: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> regulationCapability: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x2: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquivalentInjection}>Save</button>
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

export default CreateEquivalentInjectionComponent
