import React, { Component } from 'react'
import EquivalentInjectionService from '../services/EquivalentInjectionService';

class UpdateEquivalentInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
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
        this.updateEquivalentInjection = this.updateEquivalentInjection.bind(this);

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

    componentDidMount(){
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

    updateEquivalentInjection = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentInjectionService.updateEquivalentInjection(equivalentInjection).then( res => {
            this.props.history.push('/equivalentInjections');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentInjection</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> maxP: </label>
                                            #formFields( $attribute, 'update')
                                            <label> maxQ: </label>
                                            #formFields( $attribute, 'update')
                                            <label> minP: </label>
                                            #formFields( $attribute, 'update')
                                            <label> minQ: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> regulationCapability: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x2: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentInjection}>Save</button>
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

export default UpdateEquivalentInjectionComponent
