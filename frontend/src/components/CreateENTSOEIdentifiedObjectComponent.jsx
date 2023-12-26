import React, { Component } from 'react'
import ENTSOEIdentifiedObjectService from '../services/ENTSOEIdentifiedObjectService';

class CreateENTSOEIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                energyIdentCodeEic: '',
                shortName: ''
        }
        this.changeenergyIdentCodeEicHandler = this.changeenergyIdentCodeEicHandler.bind(this);
        this.changeshortNameHandler = this.changeshortNameHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ENTSOEIdentifiedObjectService.getENTSOEIdentifiedObjectById(this.state.id).then( (res) =>{
                let eNTSOEIdentifiedObject = res.data;
                this.setState({
                    energyIdentCodeEic: eNTSOEIdentifiedObject.energyIdentCodeEic,
                    shortName: eNTSOEIdentifiedObject.shortName
                });
            });
        }        
    }
    saveOrUpdateENTSOEIdentifiedObject = (e) => {
        e.preventDefault();
        let eNTSOEIdentifiedObject = {
                eNTSOEIdentifiedObjectId: this.state.id,
                energyIdentCodeEic: this.state.energyIdentCodeEic,
                shortName: this.state.shortName
            };
        console.log('eNTSOEIdentifiedObject => ' + JSON.stringify(eNTSOEIdentifiedObject));

        // step 5
        if(this.state.id === '_add'){
            eNTSOEIdentifiedObject.eNTSOEIdentifiedObjectId=''
            ENTSOEIdentifiedObjectService.createENTSOEIdentifiedObject(eNTSOEIdentifiedObject).then(res =>{
                this.props.history.push('/eNTSOEIdentifiedObjects');
            });
        }else{
            ENTSOEIdentifiedObjectService.updateENTSOEIdentifiedObject(eNTSOEIdentifiedObject).then( res => {
                this.props.history.push('/eNTSOEIdentifiedObjects');
            });
        }
    }
    
    changeenergyIdentCodeEicHandler= (event) => {
        this.setState({energyIdentCodeEic: event.target.value});
    }
    changeshortNameHandler= (event) => {
        this.setState({shortName: event.target.value});
    }

    cancel(){
        this.props.history.push('/eNTSOEIdentifiedObjects');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ENTSOEIdentifiedObject</h3>
        }else{
            return <h3 className="text-center">Update ENTSOEIdentifiedObject</h3>
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
                                            <label> energyIdentCodeEic: </label>
                                            #formFields( $attribute, 'create')
                                            <label> shortName: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateENTSOEIdentifiedObject}>Save</button>
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

export default CreateENTSOEIdentifiedObjectComponent
