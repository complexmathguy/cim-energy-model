import React, { Component } from 'react'
import ENTSOEOperationalLimitTypeService from '../services/ENTSOEOperationalLimitTypeService';

class UpdateENTSOEOperationalLimitTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                limitType: ''
        }
        this.updateENTSOEOperationalLimitType = this.updateENTSOEOperationalLimitType.bind(this);

        this.changelimitTypeHandler = this.changelimitTypeHandler.bind(this);
    }

    componentDidMount(){
        ENTSOEOperationalLimitTypeService.getENTSOEOperationalLimitTypeById(this.state.id).then( (res) =>{
            let eNTSOEOperationalLimitType = res.data;
            this.setState({
                limitType: eNTSOEOperationalLimitType.limitType
            });
        });
    }

    updateENTSOEOperationalLimitType = (e) => {
        e.preventDefault();
        let eNTSOEOperationalLimitType = {
            eNTSOEOperationalLimitTypeId: this.state.id,
            limitType: this.state.limitType
        };
        console.log('eNTSOEOperationalLimitType => ' + JSON.stringify(eNTSOEOperationalLimitType));
        console.log('id => ' + JSON.stringify(this.state.id));
        ENTSOEOperationalLimitTypeService.updateENTSOEOperationalLimitType(eNTSOEOperationalLimitType).then( res => {
            this.props.history.push('/eNTSOEOperationalLimitTypes');
        });
    }

    changelimitTypeHandler= (event) => {
        this.setState({limitType: event.target.value});
    }

    cancel(){
        this.props.history.push('/eNTSOEOperationalLimitTypes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ENTSOEOperationalLimitType</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> limitType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateENTSOEOperationalLimitType}>Save</button>
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

export default UpdateENTSOEOperationalLimitTypeComponent
