import React, { Component } from 'react'
import VCompIEEEType2Service from '../services/VCompIEEEType2Service';

class UpdateVCompIEEEType2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                tr: ''
        }
        this.updateVCompIEEEType2 = this.updateVCompIEEEType2.bind(this);

        this.changetrHandler = this.changetrHandler.bind(this);
    }

    componentDidMount(){
        VCompIEEEType2Service.getVCompIEEEType2ById(this.state.id).then( (res) =>{
            let vCompIEEEType2 = res.data;
            this.setState({
                tr: vCompIEEEType2.tr
            });
        });
    }

    updateVCompIEEEType2 = (e) => {
        e.preventDefault();
        let vCompIEEEType2 = {
            vCompIEEEType2Id: this.state.id,
            tr: this.state.tr
        };
        console.log('vCompIEEEType2 => ' + JSON.stringify(vCompIEEEType2));
        console.log('id => ' + JSON.stringify(this.state.id));
        VCompIEEEType2Service.updateVCompIEEEType2(vCompIEEEType2).then( res => {
            this.props.history.push('/vCompIEEEType2s');
        });
    }

    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }

    cancel(){
        this.props.history.push('/vCompIEEEType2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VCompIEEEType2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> tr: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVCompIEEEType2}>Save</button>
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

export default UpdateVCompIEEEType2Component
