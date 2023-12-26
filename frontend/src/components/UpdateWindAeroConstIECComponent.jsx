import React, { Component } from 'react'
import WindAeroConstIECService from '../services/WindAeroConstIECService';

class UpdateWindAeroConstIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindAeroConstIEC = this.updateWindAeroConstIEC.bind(this);

    }

    componentDidMount(){
        WindAeroConstIECService.getWindAeroConstIECById(this.state.id).then( (res) =>{
            let windAeroConstIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindAeroConstIEC = (e) => {
        e.preventDefault();
        let windAeroConstIEC = {
            windAeroConstIECId: this.state.id,
        };
        console.log('windAeroConstIEC => ' + JSON.stringify(windAeroConstIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindAeroConstIECService.updateWindAeroConstIEC(windAeroConstIEC).then( res => {
            this.props.history.push('/windAeroConstIECs');
        });
    }


    cancel(){
        this.props.history.push('/windAeroConstIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindAeroConstIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindAeroConstIEC}>Save</button>
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

export default UpdateWindAeroConstIECComponent
