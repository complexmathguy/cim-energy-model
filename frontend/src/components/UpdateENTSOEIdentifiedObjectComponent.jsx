import React, { Component } from 'react'
import ENTSOEIdentifiedObjectService from '../services/ENTSOEIdentifiedObjectService';

class UpdateENTSOEIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                energyIdentCodeEic: '',
                shortName: ''
        }
        this.updateENTSOEIdentifiedObject = this.updateENTSOEIdentifiedObject.bind(this);

        this.changeenergyIdentCodeEicHandler = this.changeenergyIdentCodeEicHandler.bind(this);
        this.changeshortNameHandler = this.changeshortNameHandler.bind(this);
    }

    componentDidMount(){
        ENTSOEIdentifiedObjectService.getENTSOEIdentifiedObjectById(this.state.id).then( (res) =>{
            let eNTSOEIdentifiedObject = res.data;
            this.setState({
                energyIdentCodeEic: eNTSOEIdentifiedObject.energyIdentCodeEic,
                shortName: eNTSOEIdentifiedObject.shortName
            });
        });
    }

    updateENTSOEIdentifiedObject = (e) => {
        e.preventDefault();
        let eNTSOEIdentifiedObject = {
            eNTSOEIdentifiedObjectId: this.state.id,
            energyIdentCodeEic: this.state.energyIdentCodeEic,
            shortName: this.state.shortName
        };
        console.log('eNTSOEIdentifiedObject => ' + JSON.stringify(eNTSOEIdentifiedObject));
        console.log('id => ' + JSON.stringify(this.state.id));
        ENTSOEIdentifiedObjectService.updateENTSOEIdentifiedObject(eNTSOEIdentifiedObject).then( res => {
            this.props.history.push('/eNTSOEIdentifiedObjects');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ENTSOEIdentifiedObject</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> energyIdentCodeEic: </label>
                                            #formFields( $attribute, 'update')
                                            <label> shortName: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateENTSOEIdentifiedObject}>Save</button>
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

export default UpdateENTSOEIdentifiedObjectComponent
