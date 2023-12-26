import React, { Component } from 'react'
import ENTSOEOperationalLimitTypeService from '../services/ENTSOEOperationalLimitTypeService';

class CreateENTSOEOperationalLimitTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                limitType: ''
        }
        this.changelimitTypeHandler = this.changelimitTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ENTSOEOperationalLimitTypeService.getENTSOEOperationalLimitTypeById(this.state.id).then( (res) =>{
                let eNTSOEOperationalLimitType = res.data;
                this.setState({
                    limitType: eNTSOEOperationalLimitType.limitType
                });
            });
        }        
    }
    saveOrUpdateENTSOEOperationalLimitType = (e) => {
        e.preventDefault();
        let eNTSOEOperationalLimitType = {
                eNTSOEOperationalLimitTypeId: this.state.id,
                limitType: this.state.limitType
            };
        console.log('eNTSOEOperationalLimitType => ' + JSON.stringify(eNTSOEOperationalLimitType));

        // step 5
        if(this.state.id === '_add'){
            eNTSOEOperationalLimitType.eNTSOEOperationalLimitTypeId=''
            ENTSOEOperationalLimitTypeService.createENTSOEOperationalLimitType(eNTSOEOperationalLimitType).then(res =>{
                this.props.history.push('/eNTSOEOperationalLimitTypes');
            });
        }else{
            ENTSOEOperationalLimitTypeService.updateENTSOEOperationalLimitType(eNTSOEOperationalLimitType).then( res => {
                this.props.history.push('/eNTSOEOperationalLimitTypes');
            });
        }
    }
    
    changelimitTypeHandler= (event) => {
        this.setState({limitType: event.target.value});
    }

    cancel(){
        this.props.history.push('/eNTSOEOperationalLimitTypes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ENTSOEOperationalLimitType</h3>
        }else{
            return <h3 className="text-center">Update ENTSOEOperationalLimitType</h3>
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
                                            <label> limitType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateENTSOEOperationalLimitType}>Save</button>
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

export default CreateENTSOEOperationalLimitTypeComponent
