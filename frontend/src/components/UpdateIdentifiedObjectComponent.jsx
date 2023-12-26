import React, { Component } from 'react'
import IdentifiedObjectService from '../services/IdentifiedObjectService';

class UpdateIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                description: '',
                energyIdentCodeEic: '',
                mRID: '',
                name: '',
                shortName: ''
        }
        this.updateIdentifiedObject = this.updateIdentifiedObject.bind(this);

        this.changedescriptionHandler = this.changedescriptionHandler.bind(this);
        this.changeenergyIdentCodeEicHandler = this.changeenergyIdentCodeEicHandler.bind(this);
        this.changemRIDHandler = this.changemRIDHandler.bind(this);
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changeshortNameHandler = this.changeshortNameHandler.bind(this);
    }

    componentDidMount(){
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

    updateIdentifiedObject = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        IdentifiedObjectService.updateIdentifiedObject(identifiedObject).then( res => {
            this.props.history.push('/identifiedObjects');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update IdentifiedObject</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> description: </label>
                                            #formFields( $attribute, 'update')
                                            <label> energyIdentCodeEic: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mRID: </label>
                                            #formFields( $attribute, 'update')
                                            <label> name: </label>
                                            #formFields( $attribute, 'update')
                                            <label> shortName: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateIdentifiedObject}>Save</button>
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

export default UpdateIdentifiedObjectComponent
