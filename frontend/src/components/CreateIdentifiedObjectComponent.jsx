import React, { Component } from 'react'
import IdentifiedObjectService from '../services/IdentifiedObjectService';

class CreateIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                description: '',
                energyIdentCodeEic: '',
                mRID: '',
                name: '',
                shortName: ''
        }
        this.changedescriptionHandler = this.changedescriptionHandler.bind(this);
        this.changeenergyIdentCodeEicHandler = this.changeenergyIdentCodeEicHandler.bind(this);
        this.changemRIDHandler = this.changemRIDHandler.bind(this);
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changeshortNameHandler = this.changeshortNameHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            IdentifiedObjectService.getIdentifiedObjectById(this.state.id).then( (res) =>{
                let identifiedObject = res.data;
                this.setState({
                    description: identifiedObject.description,
                    energyIdentCodeEic: identifiedObject.energyIdentCodeEic,
                    mRID: identifiedObject.mRID,
                    name: identifiedObject.name,
                    shortName: identifiedObject.shortName
                });
            });
        }        
    }
    saveOrUpdateIdentifiedObject = (e) => {
        e.preventDefault();
        let identifiedObject = {
                identifiedObjectId: this.state.id,
                description: this.state.description,
                energyIdentCodeEic: this.state.energyIdentCodeEic,
                mRID: this.state.mRID,
                name: this.state.name,
                shortName: this.state.shortName
            };
        console.log('identifiedObject => ' + JSON.stringify(identifiedObject));

        // step 5
        if(this.state.id === '_add'){
            identifiedObject.identifiedObjectId=''
            IdentifiedObjectService.createIdentifiedObject(identifiedObject).then(res =>{
                this.props.history.push('/identifiedObjects');
            });
        }else{
            IdentifiedObjectService.updateIdentifiedObject(identifiedObject).then( res => {
                this.props.history.push('/identifiedObjects');
            });
        }
    }
    
    changedescriptionHandler= (event) => {
        this.setState({description: event.target.value});
    }
    changeenergyIdentCodeEicHandler= (event) => {
        this.setState({energyIdentCodeEic: event.target.value});
    }
    changemRIDHandler= (event) => {
        this.setState({mRID: event.target.value});
    }
    changenameHandler= (event) => {
        this.setState({name: event.target.value});
    }
    changeshortNameHandler= (event) => {
        this.setState({shortName: event.target.value});
    }

    cancel(){
        this.props.history.push('/identifiedObjects');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add IdentifiedObject</h3>
        }else{
            return <h3 className="text-center">Update IdentifiedObject</h3>
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
                                            <label> description: </label>
                                            #formFields( $attribute, 'create')
                                            <label> energyIdentCodeEic: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mRID: </label>
                                            #formFields( $attribute, 'create')
                                            <label> name: </label>
                                            #formFields( $attribute, 'create')
                                            <label> shortName: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateIdentifiedObject}>Save</button>
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

export default CreateIdentifiedObjectComponent
