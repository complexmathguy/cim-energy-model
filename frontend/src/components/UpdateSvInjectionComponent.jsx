import React, { Component } from 'react'
import SvInjectionService from '../services/SvInjectionService';

class UpdateSvInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                pInjection: '',
                qInjection: ''
        }
        this.updateSvInjection = this.updateSvInjection.bind(this);

        this.changepInjectionHandler = this.changepInjectionHandler.bind(this);
        this.changeqInjectionHandler = this.changeqInjectionHandler.bind(this);
    }

    componentDidMount(){
        SvInjectionService.getSvInjectionById(this.state.id).then( (res) =>{
            let svInjection = res.data;
            this.setState({
                pInjection: svInjection.pInjection,
                qInjection: svInjection.qInjection
            });
        });
    }

    updateSvInjection = (e) => {
        e.preventDefault();
        let svInjection = {
            svInjectionId: this.state.id,
            pInjection: this.state.pInjection,
            qInjection: this.state.qInjection
        };
        console.log('svInjection => ' + JSON.stringify(svInjection));
        console.log('id => ' + JSON.stringify(this.state.id));
        SvInjectionService.updateSvInjection(svInjection).then( res => {
            this.props.history.push('/svInjections');
        });
    }

    changepInjectionHandler= (event) => {
        this.setState({pInjection: event.target.value});
    }
    changeqInjectionHandler= (event) => {
        this.setState({qInjection: event.target.value});
    }

    cancel(){
        this.props.history.push('/svInjections');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SvInjection</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> pInjection: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qInjection: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSvInjection}>Save</button>
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

export default UpdateSvInjectionComponent
